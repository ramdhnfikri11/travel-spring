package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Employee;
import com.example.demo.handler.Response;
import com.example.demo.services.EmployeeService;

@RestController
@RequestMapping("api")
@CrossOrigin
public class EmployeeRestController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("employee")
    public ResponseEntity<Object> get(){
        return Response.generateResponse( HttpStatus.OK, "All Datas Retrieved", employeeService.Get());
    }

    @GetMapping("employee/{id}")
    public ResponseEntity<Object> get(@PathVariable(required = true) Integer id) {
        return Response.generateResponse(HttpStatus.OK, "Data Retrieved",   employeeService.Get(id));
    }

    @PostMapping("employee")
    public ResponseEntity<Object> save(@RequestBody Employee employee){

        employeeService.Save(employee);
        return Response.generateResponse(HttpStatus.OK,"Data has been saved");
    }

}
