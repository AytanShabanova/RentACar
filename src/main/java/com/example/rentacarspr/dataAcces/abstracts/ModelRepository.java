package com.example.rentacarspr.dataAcces.abstracts;


import com.example.rentacarspr.concretes.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model,Integer> {
}
