package com.example.demo.services;

import com.example.demo.dto.ChangePasswordRequest;
import com.example.demo.dto.Login;
import com.example.demo.dto.RegisterRequest;

public interface AccountService {
    public Boolean register(RegisterRequest registerRequest);
    public Boolean changePassword(ChangePasswordRequest changePasswordRequest);
    public Boolean isTruePassword(ChangePasswordRequest changePasswordRequest);
    public Boolean forgotPassword(Login login);
}
