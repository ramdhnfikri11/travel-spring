package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Posttravel;
import com.example.demo.handler.Response;
import com.example.demo.services.PosttravelService;

@RestController
@RequestMapping("api")
public class PosttravelRestController {
    @Autowired
    private PosttravelService posttravelService;

    @GetMapping("posttravel")
    public ResponseEntity<Object> get(){
        return Response.generateResponse( HttpStatus.OK, "All Datas Retrieved", posttravelService.Get());
    }

    @GetMapping("posttravel/{id}")
    public ResponseEntity<Object> get(@PathVariable(required = true) Integer id) {
        return Response.generateResponse(HttpStatus.OK, "Data Retrieved",   posttravelService.Get(id));
    }

    @PostMapping("posttravel")
    public ResponseEntity<Object> save(@RequestBody Posttravel posttravel){
        posttravelService.Save(posttravel);
        return Response.generateResponse(HttpStatus.OK,"Data has been saved");
    }

}
