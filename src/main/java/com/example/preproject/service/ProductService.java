package com.example.preproject.service;

import com.example.preproject.dto.ProductDTO;
import com.example.preproject.entity.Product;
import com.example.preproject.mapper.ProductMapper;
import com.example.preproject.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDTO> findAll() {
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOS = new ArrayList<>();
        for (Product product : products) {
            productDTOS.add(ProductMapper.INSTANCE.toProductDTO(product));
        }
        return productDTOS;
    }

    public ProductDTO findById(long id) {
        return ProductMapper.INSTANCE.toProductDTO(productRepository.findById(id).orElse(null));
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
        if (price != null) {
            if (!price.equals(product.getPrice())) {
                product.setPrice(price);
            }
        } else {
            throw new IllegalStateException("Цена не может быть null");
        }
        productRepository.save(product);
    }
}
