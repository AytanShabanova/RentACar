package com.example.rentacarspr.businnes.concerets;

import com.example.rentacarspr.businnes.abstracts.ModelService;
import com.example.rentacarspr.businnes.requests.CreateModelRequest;
import com.example.rentacarspr.businnes.responses.GetAllModelsResponse;
import com.example.rentacarspr.concretes.Model;
import com.example.rentacarspr.dataAcces.abstracts.ModelRepository;
import com.example.rentacarspr.mappers.ModelMapperService;
import lombok.RequiredArgsConstructor;


import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ModelManager implements ModelService {
    private final ModelRepository modelRepository;
    private final ModelMapperService modelMapperService;
    @Override
    public List<GetAllModelsResponse> getAll() {
        List<Model>models= modelRepository.findAll();
        List<GetAllModelsResponse>modelsResponses=models.stream()
                .map(model -> modelMapperService.forResponse().map(model, GetAllModelsResponse.class)).collect(Collectors.toList());

        return modelsResponses;
    }

    @Override
    public void add(CreateModelRequest createModelRequest) {
        Model model=modelMapperService.forRequest().map(createModelRequest, Model.class);
        modelRepository.save(model);
    }
}
