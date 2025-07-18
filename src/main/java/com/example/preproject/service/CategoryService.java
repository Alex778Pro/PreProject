package com.example.preproject.service;

import com.example.preproject.entity.Category;
import com.example.preproject.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public Category create(Category category) {
        Optional<Category> categoryOptional = categoryRepository.findByName(category.getName());
        if (categoryOptional.isPresent()) {
            throw new IllegalArgumentException("Категория " + category.getName() + " уже существует");
        }
        return categoryRepository.save(category);
    }

    public Category update(Long id, String name, String description) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isEmpty()) {
            throw new IllegalStateException("Категории с id " + id + " не существует");
        }
        Category category = categoryOptional.get();
        if (category.getName().equals(name)) {
            throw new IllegalStateException("Такая категория уже существует");
        }
        category.setName(name);
        if (description != null && !category.getDescription().equals(description)) {
            category.setDescription(description);
        }
        return categoryRepository.save(category);
    }
    public void delete(Long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isEmpty()) {
            throw new IllegalStateException("Категории с id " + id + " не существует");
        }
        categoryRepository.deleteById(id);
    }
}
