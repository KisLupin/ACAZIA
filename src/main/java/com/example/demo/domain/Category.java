package com.example.demo.domain;

import com.example.demo.object.request.CategoryRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "category")
@Getter
@Setter
@NoArgsConstructor
public class Category implements Serializable {
    @Id
    private String tag;
    private String name;
    @OneToMany(mappedBy = "category")
    private List<Product> products;

    public Category(CategoryRequest c) {
        if (Objects.isNull(c)){
            return;
        }
        BeanUtils.copyProperties(c, this);
    }

    public void update(CategoryRequest c) {
        if (Objects.isNull(c)){
            return;
        }
        BeanUtils.copyProperties(c, this);
    }
}
