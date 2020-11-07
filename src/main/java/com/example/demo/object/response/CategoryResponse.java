package com.example.demo.object.response;

import com.example.demo.domain.Category;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.Objects;

@Getter
@Setter
public class CategoryResponse {
    private String tag;
    private String name;

    public CategoryResponse(Category c) {
        if (Objects.isNull(c)){
            return;
        }
        BeanUtils.copyProperties(c, this);
    }
}
