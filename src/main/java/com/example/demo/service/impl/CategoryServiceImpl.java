package com.example.demo.service.impl;

import com.example.demo.domain.Category;
import com.example.demo.object.request.CategoryRequest;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
@Transactional
public class CategoryServiceImpl implements CategoryService<Category, CategoryRequest> {
    private final CategoryRepository categoryRepository;

    @Override
    public Category create(CategoryRequest condition) {
        Category category = new Category(condition);
        return categoryRepository.save(category);
    }

    @Override
    public Category edit(CategoryRequest condition) {
        Category category = categoryRepository.findByTag(condition.getTag())
                .orElse(null);
        if (Objects.nonNull(category)){
            category.update(condition);
            return categoryRepository.save(category);
        }
        return null;
    }

    @Override
    public Category detail(String tag) {
        return categoryRepository.findByTag(tag).orElse(null);
    }

    @Override
    public List<Category> all() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Category> find(String text) {
        return categoryRepository.findByNameContainingIgnoreCase(text);
    }

    @Override
    public void delete(String tag) {
        categoryRepository.deleteByTag(tag);
    }
}
