package com.example.demo.service;

import java.util.List;

public interface CategoryService<T, U> {
    T create(U condition);
    T edit(U condition);
    T detail(String tag);
    List<T> all();
    List<T> find(String text);
    void delete(String tag);
}
