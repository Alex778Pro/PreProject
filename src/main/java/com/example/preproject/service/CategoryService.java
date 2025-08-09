package com.example.preproject.service;

import com.example.preproject.entity.Category;
import com.example.preproject.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Transactional
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Transactional
    public Category findById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Transactional
    public Category create(Category category) {
        Optional<Category> categoryOptional = categoryRepository.findByName(category.getName());
        if (categoryOptional.isPresent()) {
            throw new IllegalArgumentException("Категория " + category.getName() + " уже существует");
        }
        return categoryRepository.save(category);
    }

    @Transactional
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

    @Transactional
    public void delete(Long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isEmpty()) {
            throw new IllegalStateException("Категории с id " + id + " не существует");
        }
        categoryRepository.deleteById(id);
    }
}
