package com.example.demo.domain;

import com.example.demo.object.request.ProductRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Double price;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryTag", referencedColumnName = "tag")
    private Category category;

    public Product(ProductRequest p, Category c) {
        if (Objects.isNull(p)){
            return;
        }
        BeanUtils.copyProperties(p, this);
        this.category = c;
    }

    public void update(ProductRequest p, Category c){
        if (Objects.isNull(p)){
            return;
        }
        BeanUtils.copyProperties(p, this);
        this.category = c;
    }
}
