package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Travel;

public interface RequestRepository extends JpaRepository<Travel, Integer>{
    
}
