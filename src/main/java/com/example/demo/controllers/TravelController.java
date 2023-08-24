package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.Posttravel;
import com.example.demo.entities.Travel;
import com.example.demo.services.EmployeeService;
import com.example.demo.services.TravelService;

@Controller
@RequestMapping("travel")
public class TravelController {
    @Autowired
    TravelService travelService;

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("travels", travelService.Get());
        return "travel/index";
    }

    @GetMapping(value = {"form", "form/{id}"})
    public String form( @PathVariable(required = false) Integer id, Model model) {
        if (id != null) {
            model.addAttribute("travel", travelService.Get(id));
            model.addAttribute("employees", employeeService.Get());
        } else {
            model.addAttribute("travel", new Travel());
            model.addAttribute("employees", employeeService.Get());
        }
        return "travel/form";
    }

    @PostMapping("save")
    public String submit(Travel travel){
        Boolean result = travelService.Save(travel);
        if(result){
            return "redirect:/travel";
        }else{
            return "travel/form";
        }
    }

    @PostMapping("delete/{id}")
    public String delete(Travel travel, @PathVariable(required = true)Integer id){
        travelService.Delete(id);
        return "redirect:/travel";
    }
}
