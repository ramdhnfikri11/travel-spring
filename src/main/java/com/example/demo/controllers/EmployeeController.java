package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.Employee;
import com.example.demo.services.EmployeeService;

@Controller
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("employees", employeeService.Get());
        return "employee/index";
    }

    @GetMapping(value = {"form", "form/{id}"})
    public String form( @PathVariable(required = false) Integer id, Model model) {
        if (id != null) {
            model.addAttribute("employee", employeeService.Get(id));
        } else {
            model.addAttribute("employee", new Employee());
        }
        return "employee/form";
    }


    // @PostMapping("save")
    // public String submit(Region region){
    //     Boolean result= regionService.Save(region);
    //     if (result) {
    //         return "redirect:/region";
    //     } else{
    //         return "region:/form";
    //     }
    // }
    // save
    // region/save
    // @PostMapping("save")
    // public String regionSave(Region region) {
    //     regionService.Save(region);
    //     return "redirect:/region";
    // }

    // delete
    // region/delete/1
    // @PostMapping("delete/{id}")
    // public String regionDelete(@PathVariable(required =true) Integer id){
    //     regionService.Delete(id);
    //     return "redirect:/region";
    // }
}
