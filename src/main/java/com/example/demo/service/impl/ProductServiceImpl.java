package com.example.demo.service.impl;

import com.example.demo.domain.Category;
import com.example.demo.domain.Product;
import com.example.demo.object.request.ProductRequest;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.BaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
@Transactional
public class ProductServiceImpl implements BaseService<Product, ProductRequest> {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public Product create(ProductRequest condition) {
        Category category = categoryRepository.findByTag(condition.getCategoryTag()).orElse(null);
        Product product = new Product(condition, category);
        return productRepository.save(product);
    }

    @Override
    public Product edit(ProductRequest condition) {
        Product product = productRepository.findById(condition.getId()).orElse(null);
        if (Objects.nonNull(product)){
            Category category = categoryRepository.findByTag(condition.getCategoryTag()).orElse(null);
            product.update(condition, category);
            productRepository.save(product);
        }
        return null;
    }

    @Override
    public Product detail(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> all() {
        return productRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        productRepository.deleteById(id);
    }
}
