package com.example.rentacarspr.businnes.abstracts;


import com.example.rentacarspr.businnes.requests.CreateModelRequest;
import com.example.rentacarspr.businnes.responses.GetAllModelsResponse;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ModelService {
    List<GetAllModelsResponse> getAll();
    void add(CreateModelRequest createModelRequest);
}
