package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ChangePasswordRequest;
import com.example.demo.dto.Login;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entities.Employee;
import com.example.demo.entities.Role;
import com.example.demo.entities.User;

@Service
public class AccountServiceImpl implements AccountService{
    @Autowired
    private UserService userService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public Boolean register(RegisterRequest registerRequest) {
        Employee employee =new Employee();

        employee.setEmail(registerRequest.getEmail());
        employee.setName(registerRequest.getName());
        employee.setPhone_number(null);
        employee.setAddress(null);
        // insert to employee
        Boolean resultEmployee= employeeService.Save(employee);
        if (resultEmployee) {
            //tampung role yang di tentukan
            Role role=new Role();
            role.setRole_id(1);
            // insert to user
            Integer employee_id = employeeService.findIdByEmail(registerRequest.getEmail());
            User user = new User();
            
            
            user.setUser_id(employee_id);
            user.setRole(role);
            user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));

            Boolean resultUser=userService.Save(user);
            return resultUser;
        }
        return resultEmployee;
    }

    @Override
    public Boolean changePassword(ChangePasswordRequest changePasswordRequest) {
        Integer employee_id = employeeService.findIdByEmail(changePasswordRequest.getEmail());
        Boolean checkPassword = isTruePassword(changePasswordRequest);
        if (checkPassword) {
            User user = userService.Get(employee_id);
            user.setPassword(passwordEncoder.encode(changePasswordRequest.getNew_password()));
            Boolean resultUser=userService.Save(user);
            return resultUser;
        }
        return false;
    }

    @Override
    public Boolean isTruePassword(ChangePasswordRequest changePasswordRequest) {
        Integer employee_id = employeeService.findIdByEmail(changePasswordRequest.getEmail());
        User user = userService.Get(employee_id);
        if (user !=null) {
            boolean result = passwordEncoder.matches(changePasswordRequest.getOld_password(), user.getPassword());
            return result;
        }else{
            return false;
        }
    }

    @Override
    public Boolean forgotPassword(Login login) {
        Integer employee_id = employeeService.findIdByEmail(login.getEmail());
        User user = userService.Get(employee_id);
        if (user != null) {
            user.setPassword(passwordEncoder.encode(login.getPassword()));
            Boolean resultUser=userService.Save(user);
            return resultUser;
        }
        return false;
    }
    
}
