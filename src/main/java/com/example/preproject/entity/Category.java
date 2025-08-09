package com.example.preproject.entity;

import com.example.preproject.dto.ProductDTO;
import com.example.preproject.mapper.ProductMapper;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Название категории не может быть пустым")
    @Size(max = 50, message = "Максимальное число символов 50")
    private String name;

    private String description;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products;

    public List<ProductDTO> getProducts() {
        List<ProductDTO> productDTOS = new ArrayList<>();
        for (Product product : products) {
            productDTOS.add(ProductMapper.INSTANCE.toProductDTO(product));
        }
        return productDTOS;
    }
}
