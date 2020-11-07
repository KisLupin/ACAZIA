package com.example.demo.service;

import java.util.List;

public interface BaseService<T, U> {
    T create(U condition);
    T edit(U condition);
    T detail(Integer id);
    List<T> all();
    void delete(Integer id);
}
