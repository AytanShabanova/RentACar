package com.example.rentacarspr.controllers;

import com.example.rentacarspr.businnes.abstracts.ModelService;
import com.example.rentacarspr.businnes.requests.CreateModelRequest;
import com.example.rentacarspr.businnes.responses.GetAllModelsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/models")
@RequiredArgsConstructor
public class ModelsController {
    private final ModelService modelService;
    @GetMapping()
    public List<GetAllModelsResponse> getALL(){

        return modelService.getAll();
    }
    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(CreateModelRequest createModelRequest){
        modelService.add(createModelRequest);

    }
}
