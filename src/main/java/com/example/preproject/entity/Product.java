package com.example.preproject.entity;

import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.*;

@Data
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor

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
    @Positive(message = "Цена должна быть положительна")
    private double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

}
