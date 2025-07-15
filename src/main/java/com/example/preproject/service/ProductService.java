package com.example.preproject.service;

import com.example.preproject.repository.Product;
import com.example.preproject.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product create(Product product) {
        Optional<Product> optionalProduct = productRepository.findByName(product.getName());
        if (optionalProduct.isPresent()) {
            throw new IllegalStateException("Такой продукт уже существует");
        }
        return productRepository.save(product);
    }

    public void delete(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) {
            throw new IllegalStateException("Продукта с id" + id + "не существует");
        }
        productRepository.deleteById(id);
    }

    public void update(Long id, String name, String description, Double price) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) {
            throw new IllegalStateException("Продукта с id" + id + "не существует");
        }
        Product product = optionalProduct.get();
        if (name != null && !name.equals(product.getName())) {
            Optional<Product> findProduct = productRepository.findByName(name);
            if (findProduct.isPresent()) {
                throw new IllegalStateException("Такой продукт уже существует");
            }
            product.setName(name);
        }
        if (description != null && !description.equals(product.getDescription())) {
            product.setDescription(description);
        }
        productRepository.save(product);
    }
}
