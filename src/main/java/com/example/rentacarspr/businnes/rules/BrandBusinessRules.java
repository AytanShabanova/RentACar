package com.example.rentacarspr.businnes.rules;

import com.example.rentacarspr.dataAcces.abstracts.BrandRepository;
import com.example.rentacarspr.utilities.exceptions.BusinesExcepiton;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BrandBusinessRules {
    //ioc de yerlessin deye service anotationu qoyuruq
    //statik etmeye ehdiyac yoxdur cunki bu klasi singleton isdifade edeceyik
    private final BrandRepository brandRepository;
    public void checkIfBrandNameExists(String name){
if (brandRepository.existsByName(name)){
    throw new BusinesExcepiton("DONT FOUNT BRANDNAME");
}
    }



}
