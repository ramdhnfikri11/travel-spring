package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.Posttravel;
import com.example.demo.services.PosttravelService;
import com.example.demo.services.TravelService;

@Controller
@RequestMapping("posttravel")
public class PosttravelController {
    @Autowired
    PosttravelService posttravelService;

    @Autowired
    TravelService travelService;

    
    @GetMapping
    public String index(Model model){
        model.addAttribute("posttravels", posttravelService.Get());
        return "posttravel/index";
    }

    @GetMapping(value = {"form", "form/{id}"})
    public String form(Model model, @PathVariable(required = false)Integer id){
        if(id != null ){
            model.addAttribute("travels", travelService.Get());
            model.addAttribute("posttravel", posttravelService.Get(id));
        }else{
            model.addAttribute("travels", travelService.Get());
            model.addAttribute("posttravel", new Posttravel());
        }
        return "posttravel/form";
    }

    @PostMapping("save")
    public String submit(Posttravel posttravel){
        Boolean result = posttravelService.Save(posttravel);
        if(result){
            return "redirect:/posttravel";
        }else{
            return "posttravel/form";
        }
    }

    @PostMapping("delete/{id}")
    public String delete(Posttravel posttravel, @PathVariable(required = true)Integer id){
        posttravelService.Delete(id);
        return "redirect:/posttravel";
    }
}
