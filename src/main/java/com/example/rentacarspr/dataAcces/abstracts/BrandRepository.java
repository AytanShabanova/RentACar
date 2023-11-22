package com.example.rentacarspr.dataAcces.abstracts;


import com.example.rentacarspr.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand,Integer> {


}
