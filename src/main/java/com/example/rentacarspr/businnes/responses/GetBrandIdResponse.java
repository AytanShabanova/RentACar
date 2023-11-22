package com.example.rentacarspr.businnes.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetBrandIdResponse {
    private Integer id;
    private String name;
}
