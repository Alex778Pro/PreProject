package com.example.preproject.controller;

import com.example.preproject.dto.ProductDTO;
import com.example.preproject.entity.Product;
import com.example.preproject.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor

@RestController
@RequestMapping(path = "/api/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @PostMapping
    public Product addProduct(@Valid @RequestBody Product product) {
        return productService.create(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id) {
        productService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(
            @Valid @PathVariable Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) Double price
    ) {
        productService.update(id, name, description, price);
    }
}
