package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ChangePasswordRequest;
import com.example.demo.dto.Login;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entities.User;
import com.example.demo.handler.Response;
import com.example.demo.services.AccountService;
import com.example.demo.services.EmployeeService;
import com.example.demo.services.UserService;

@RestController
@RequestMapping("api")
@CrossOrigin
public class UserRestController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private AccountService accountService;
    @Autowired
    private UserService userService;
    @Autowired
    private EmployeeService employeeService;



    @GetMapping("user")
    public ResponseEntity<Object> get(){
        return Response.generateResponse( HttpStatus.OK, "All Datas Retrieved", userService.Get());
    }

    @GetMapping("user/{id}")
    public ResponseEntity<Object> get(@PathVariable(required = true) Integer id) {
        return Response.generateResponse(HttpStatus.OK, "Data Retrieved",   userService.Get(id));
    }

    // @PostMapping("user/login")
    // public ResponseEntity<Object> login( @RequestBody Login loginValue){
    //     Authentication authentication = authenticationManager
    //         .authenticate(new UsernamePasswordAuthenticationToken(
    //             loginValue.getEmail(), loginValue.getPassword()));
    //     SecurityContextHolder.getContext().setAuthentication(authentication);
    //     if (authentication.isAuthenticated()) {
    //         return Response.generateResponse(HttpStatus.OK, "Login Successful");
    //     }
    //     return Response.generateResponse(HttpStatus.OK, "Login Gagal");
        
    // }
    @PostMapping("user/login")
    public ResponseEntity<Object> login( @RequestBody Login loginValue){
        Authentication authentication = authenticationManager
            .authenticate(new UsernamePasswordAuthenticationToken(
                loginValue.getEmail(), loginValue.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        if (authentication.isAuthenticated()) {
            Integer employee_id = employeeService.findIdByEmail(loginValue.getEmail());
            User user = new User();

            user.setUser_id(employee_id);

            return Response.generateResponse(HttpStatus.OK, "Login Successful", userService.Get(employee_id));
        }
        return Response.generateResponse(HttpStatus.OK, "Login Gagal");
        
    }
    
    @PostMapping("user/register")
    public ResponseEntity<Object> register(@RequestBody RegisterRequest registerRequest){
        Boolean result = accountService.register(registerRequest);
        if (result) {
            return Response.generateResponse(HttpStatus.OK, "Data Berhasil disimpan");
        }
        return Response.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Data Gagal disimpan");
    }
    
    @PostMapping("user/forgot")
    public ResponseEntity<Object> forgotPassword(@RequestBody Login login){
        Boolean result = accountService.forgotPassword(login);
        if (result) {
            return Response.generateResponse(HttpStatus.OK, "Password Berhasil diubah");
        }
        return Response.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Password Gagal Diubah");  
    }

    @PostMapping("profile/changePassword")
    public ResponseEntity<Object> changePassword(@RequestBody ChangePasswordRequest changePasswordRequest){
        Boolean result = accountService.changePassword(changePasswordRequest);
        if (result) {
            return Response.generateResponse(HttpStatus.OK, "Password Berhasil diubah");
        }
        return Response.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Password Gagal Diubah");   
    }
    
}
