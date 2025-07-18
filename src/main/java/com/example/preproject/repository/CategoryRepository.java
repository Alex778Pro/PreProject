package com.example.preproject.repository;

import com.example.preproject.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query(value = "select * from category where name = :name", nativeQuery = true)
    Optional<Category> findByName(String name);
}
