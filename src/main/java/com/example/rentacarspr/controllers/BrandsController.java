package com.example.rentacarspr.controllers;

import com.example.rentacarspr.businnes.abstracts.BrandService;
import com.example.rentacarspr.businnes.requests.CreateBrandRequest;
import com.example.rentacarspr.businnes.requests.UpDateBrandRequest;
import com.example.rentacarspr.businnes.responses.GetAllBrandsResponse;
import com.example.rentacarspr.businnes.responses.GetBrandIdResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
@RequiredArgsConstructor
public class BrandsController {
    private final BrandService brandService;
//@Autowired
//    public BrandsController(BrandService  brandService) {
//
//    this.brandService = brandService;
//    }
    @GetMapping()
    public List<GetAllBrandsResponse>getALL(){

        return brandService.getAll();
    }
    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(CreateBrandRequest createBrandRequest){
        brandService.add(createBrandRequest);

    }
    @GetMapping("/{id}")
    public GetBrandIdResponse getById(@PathVariable Integer id){
        return brandService.getByiD(id);
    }
    @PutMapping
    public void update(@RequestBody UpDateBrandRequest upDateBrandRequest){
        brandService.update(upDateBrandRequest);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        brandService.delete(id);
    }
}
