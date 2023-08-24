package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Travel;
import com.example.demo.repositories.TravelRepository;

@Service
public class TravelSeviceImpl implements TravelService {
    @Autowired
    TravelRepository travelRepository;

    @Override
    public List<Travel> Get() {
        return travelRepository.findAll();
    }

    @Override
    public Travel Get(Integer id) {
        return travelRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Travel tidak ditemukan"));
    }

    @Override
    public Boolean Save(Travel model) {
        travelRepository.save(model);
        return travelRepository.findById(model.getTravel_id()).isPresent();
    }

    @Override
    public Boolean Delete(Integer id) {
        travelRepository.deleteById(id);
        return !travelRepository.findById(id).isPresent();
    }
}
