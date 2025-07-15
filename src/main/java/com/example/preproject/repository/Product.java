package com.example.preproject.repository;

import jakarta.persistence.*;
import lombok.*;
//import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.Positive;
//import jakarta.validation.constraints.Size;


@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true, nullable = false)
    //@NotNull(message = "Название товара не может быть пустым")
   // @Size(max = 100, message = "Максимальная длина 100 символов")
    private String name;
    private String description;
    @Column(nullable = false)
   // @Positive(message = "Цена должны быть положительна")
    private double price;

}
