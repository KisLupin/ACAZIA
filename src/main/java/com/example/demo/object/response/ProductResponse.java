package com.example.demo.object.response;

import com.example.demo.domain.Product;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.Objects;

@Getter
@Setter
public class ProductResponse {
    private String name;
    private Double price;
    private String categoryTag;

    public ProductResponse(Product product) {
        if (Objects.isNull(product)){
            return;
        }
        BeanUtils.copyProperties(product, this);
        this.categoryTag = Objects.nonNull(product.getCategory()) ? product.getCategory().getName() : null;
    }
}
