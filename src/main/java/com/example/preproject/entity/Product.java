package com.example.preproject.entity;

import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.*;
@Data

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true, nullable = false)
    @NotBlank(message = "Название товара не может быть пустым")
    @Size(max = 100, message = "Максимальная длина 100 символов")
    private String name;
    private String description;
    @Column(nullable = false)
    @Positive(message = "Цена должны быть положительна")
    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
