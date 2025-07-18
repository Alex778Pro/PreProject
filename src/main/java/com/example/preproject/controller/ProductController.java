package com.example.preproject.controller;

import com.example.preproject.entity.Product;
import com.example.preproject.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/product")
public class ProductController {
    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id) {
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
