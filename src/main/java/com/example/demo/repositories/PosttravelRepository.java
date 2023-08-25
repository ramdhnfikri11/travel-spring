package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Posttravel;
import com.example.demo.entities.Travel;


@Repository
public interface PosttravelRepository extends JpaRepository<Posttravel, Integer>{
    //     @Query(value = "select u from Travel u join u.employee e where e.email = ?1")
    // public Travel report();
}
