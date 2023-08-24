package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.Login;
import com.example.demo.handler.Response;
import com.example.demo.services.UserService;

@Controller
@RequestMapping("user/login")
public class UserController {
    @Autowired
    private UserService userService;

     @GetMapping
    public String index() {
        return "user/login/index";
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
    //     return Response.generateResponse(HttpStatus.UNAUTHORIZED, "Login Gagal");
        
    // }
}
