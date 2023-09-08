package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class AppSecurityConfig {
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
        .csrf().disable()
        .authorizeHttpRequests((auth) -> {
            try {
                auth
                    .antMatchers("/api/**").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .formLogin()
                    .loginPage("/user/login")
                    .and()
                    .httpBasic()
                    .and()
                    .logout();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        return http.build();
    }

    // @Override
// protected void configure(HttpSecurity http) throws Exception {
//     http
//         .authorizeRequests().antMatchers("/", "/home").permitAll()
//         .mvcMatchers("/cpanel").hasRole("ADMIN")
//         .anyRequest().authenticated()
//         .and()
//         .formLogin()
//             .loginPage("/login")       
//             .permitAll()
//             .and()
//         .logout().permitAll()
//         .and()
//         .exceptionHandling().accessDeniedPage("/403");
     
// }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}