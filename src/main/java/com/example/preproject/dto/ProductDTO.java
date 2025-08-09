package com.example.preproject.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private double price;

}

