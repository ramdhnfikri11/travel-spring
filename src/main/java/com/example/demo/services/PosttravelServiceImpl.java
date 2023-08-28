package com.example.demo.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Posttravel;
import com.example.demo.repositories.PosttravelRepository;


@Service
public class PosttravelServiceImpl implements PosttravelService{
    @Autowired
    private PosttravelRepository posttravelRepository;


    @Override
    public List<Posttravel> Get() {
        return posttravelRepository.findAll();
    }

    @Override
    public Posttravel Get(Integer id) {
        return posttravelRepository.findById(id).orElseThrow(null);
    }

    @Override
    public Boolean Save(Posttravel model) {
        posttravelRepository.save(model);
        return posttravelRepository.findById(model.getPosttravel_id()).isPresent();
    }

    @Override
    public Boolean Delete(Integer id) {
        posttravelRepository.deleteById(id);
        return !posttravelRepository.findById(id).isPresent();
    }
}
