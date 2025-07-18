package com.example.preproject.controller;

import com.example.preproject.entity.Category;
import com.example.preproject.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/category")
public class CategoryController {
    CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getAllProducts() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        return categoryService.findById(id);
    }

    @PostMapping
    public Category addCategory(@Valid @RequestBody Category category) {
        return categoryService.create(category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategoryById(@PathVariable Long id) {
        categoryService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(
            @Valid @PathVariable Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String description
    ) {
        categoryService.update(id, name, description);
    }
}
