package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Travel;
import com.example.demo.handler.Response;
import com.example.demo.services.TravelService;

@RestController
@RequestMapping("api")
@CrossOrigin
public class TravelRestController {

    @Autowired
    private TravelService travelService;

    @GetMapping("travel")
    public ResponseEntity<Object> get(){
        return Response.generateResponse( HttpStatus.OK, "All Datas Retrieved", travelService.Get());
    }

    @GetMapping("travel/{id}")
    public ResponseEntity<Object> get(@PathVariable(required = true) Integer id) {
        return Response.generateResponse(HttpStatus.OK, "Data Retrieved",   travelService.Get(id));
    }
    

    @PostMapping("travel")
    public ResponseEntity<Object> save(@RequestBody Travel travel){
        travelService.Save(travel);
        return Response.generateResponse(HttpStatus.OK,"Data has been saved");
    }

    @DeleteMapping("travel/{id}")
    public ResponseEntity<Object> put(@PathVariable(required = true) Integer id) {
        Boolean result = travelService.Delete(id);
        if(result) {
            return Response.generateResponse(HttpStatus.OK,"data berhasil terhapus", HttpStatus.OK);
        }
        return Response.generateResponse(HttpStatus.BAD_REQUEST, "data gagal terhapus" );
    }
    
}
