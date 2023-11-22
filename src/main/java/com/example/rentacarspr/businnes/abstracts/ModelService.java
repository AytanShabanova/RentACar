package com.example.rentacarspr.businnes.abstracts;


import com.example.rentacarspr.businnes.responses.GetAllModelsResponse;

import java.util.List;
public interface ModelService {
    List<GetAllModelsResponse> getAll();
}
