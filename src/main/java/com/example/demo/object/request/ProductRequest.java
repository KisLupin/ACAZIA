package com.example.demo.object.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {
    private Integer id;
    private String name;
    private String categoryTag;
    private Double price;
}
