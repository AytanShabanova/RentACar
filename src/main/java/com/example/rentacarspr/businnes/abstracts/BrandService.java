package com.example.rentacarspr.businnes.abstracts;

import com.example.rentacarspr.businnes.requests.CreateBrandRequest;
import com.example.rentacarspr.businnes.requests.UpDateBrandRequest;
import com.example.rentacarspr.businnes.responses.GetAllBrandsResponse;
import com.example.rentacarspr.businnes.responses.GetBrandIdResponse;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public interface  BrandService {

    List<GetAllBrandsResponse> getAll();
    GetBrandIdResponse getByiD(Integer id);
    void add(CreateBrandRequest createBrandRequest);
    void update(UpDateBrandRequest upDateBrandRequest);
    void delete(Integer id);
}
