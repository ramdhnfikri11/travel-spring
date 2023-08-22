package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository uRepo;
    @Override
    public List<User> Get() {
        return uRepo.findAll();
    }

    @Override
    public User Get(Integer id) {
        return uRepo.findById(id).orElseThrow(null);
    }

    @Override
    public Boolean Save(User model) {
        uRepo.save(model);
        return uRepo.findById(model.getUser_id()).isPresent();
    }

    @Override
    public Boolean Delete(Integer id) {
        uRepo.deleteById(id);
        return !uRepo.findById(id).isPresent();
    }
    
}
