package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Employee;
import com.example.demo.repositories.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository eRepo;
    @Override
    public List<Employee> Get() {
        return eRepo.findAll();
    }

    @Override
    public Employee Get(Integer id) {
        return eRepo.findById(id).orElseThrow(null);
    }

    @Override
    public Boolean Save(Employee model) {
        eRepo.save(model);
        return eRepo.findById(model.getEmployee_id()).isPresent();
    }

    @Override
    public Boolean Delete(Integer id) {
        eRepo.deleteById(id);
        return !eRepo.findById(id).isPresent();
    }
    
    @Override
    public Integer findIdByEmail(String email) {
        return eRepo.findIdByEmail(email);
    }
}