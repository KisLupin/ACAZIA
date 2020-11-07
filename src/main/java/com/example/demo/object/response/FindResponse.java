package com.example.demo.object.response;

import com.example.demo.domain.Product;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.Objects;

@Getter
@Setter
public class FindResponse {
    private String name;
    private String categoryTag;
    private String categoryName;
    private Double price;

    public FindResponse(Product product) {
        if (Objects.isNull(product)){
            return;
        }
        BeanUtils.copyProperties(product, this);
        this.categoryTag = Objects.nonNull(product.getCategory()) ? product.getCategory().getTag() : null;
        this.categoryName = Objects.nonNull(product.getCategory()) ? product.getCategory().getName() : null;
    }
}
