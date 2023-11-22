package com.example.rentacarspr.businnes.concerets;


import com.example.rentacarspr.businnes.abstracts.BrandService;
import com.example.rentacarspr.businnes.requests.CreateBrandRequest;
import com.example.rentacarspr.businnes.requests.UpDateBrandRequest;
import com.example.rentacarspr.businnes.responses.GetAllBrandsResponse;
import com.example.rentacarspr.businnes.responses.GetBrandIdResponse;
import com.example.rentacarspr.concretes.Brand;
import com.example.rentacarspr.dataAcces.abstracts.BrandRepository;
import com.example.rentacarspr.mappers.ModelMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service //bu class bir biznes obyektidir

@RequiredArgsConstructor
public class BrandManager implements BrandService {
    private final BrandRepository brandRepository;
    private final ModelMapperService modelMapperService;
//@Autowired
//    public BrandManager(BrandRepository brandRepository) {
//
//    this.brandRepository = brandRepository;
//    }

    @Override
    public List<GetAllBrandsResponse> getAll() {
        //is qanunlari
        List<Brand>brands= brandRepository.findAll();
//        List<GetAllBrandsResponse>brandsResponse=new ArrayList<GetAllBrandsResponse>();
//
//        for (Brand brand: brands ) {
//            GetAllBrandsResponse responseItem = new GetAllBrandsResponse();
//            responseItem.setId(brand.getId());
//            responseItem.setName(brand.getName());
//            brandsResponse.add(responseItem);
//        }

        List<GetAllBrandsResponse>brandsResponse=brands.stream()
                .map(brand -> modelMapperService.forResponse().map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList());


        return brandsResponse ;
    }

    @Override
    public GetBrandIdResponse getByiD(Integer id) {
        Brand brand=  brandRepository.findById(id).orElseThrow(() -> new NoSuchElementException("id tapilmadi"));
  GetBrandIdResponse response=modelMapperService.forResponse().map(brand,GetBrandIdResponse.class);
  return response;

    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {
//        Brand brand=new Brand();
//        brand.setName(createBrandRequest.getName());
        Brand brand=modelMapperService.forRequest().map(createBrandRequest, Brand.class);
        brandRepository.save(brand);

    }

    @Override
    public void update(UpDateBrandRequest upDateBrandRequest) {
      Brand brand=modelMapperService.forRequest().map(upDateBrandRequest, Brand.class);
      brandRepository.save(brand);
    }

    @Override
    public void delete(Integer id) {
      brandRepository.deleteById(id);
    }
}
