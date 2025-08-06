package com.example.preproject.dto;

import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.*;

@Data
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private int id;
    private String name;
    private String description;
    private double price;
}

