package com.example.demo.controller;

import com.example.demo.domain.Product;
import com.example.demo.object.request.ProductRequest;
import com.example.demo.object.response.ProductResponse;
import com.example.demo.service.BaseService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {
    private final BaseService<Product, ProductRequest> productService;

    @PostMapping("/add")
    public ResponseEntity<ProductResponse> add(@RequestBody ProductRequest productRequest){
        Product product = productService.create(productRequest);
        ProductResponse productResponse = new ProductResponse(product);
        return ResponseEntity.ok().body(productResponse);
    }

    @PutMapping("/edit")
    public ResponseEntity<ProductResponse> edit(@RequestBody ProductRequest productRequest){
        Product product = productService.edit(productRequest);
        ProductResponse productResponse = new ProductResponse(product);
        return ResponseEntity.ok().body(productResponse);
    }

    @GetMapping("/")
    public ResponseEntity<List<ProductResponse>> all(){
        List<Product> products = productService.all();
        List<ProductResponse> productResponses = products.stream().map(ProductResponse::new).collect(toList());
        return ResponseEntity.ok().body(productResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> detail(@PathVariable Integer id){
        Product product = productService.detail(id);
        ProductResponse productResponse = new ProductResponse(product);
        return ResponseEntity.ok().body(productResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        productService.delete(id);
        return ResponseEntity.ok().build();
    }
}
