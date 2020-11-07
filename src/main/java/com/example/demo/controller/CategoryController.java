package com.example.demo.controller;

import com.example.demo.domain.Category;
import com.example.demo.object.request.CategoryRequest;
import com.example.demo.object.response.CategoryResponse;
import com.example.demo.object.response.FindResponse;
import com.example.demo.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/category")
@AllArgsConstructor
public class CategoryController {
    private final CategoryService<Category, CategoryRequest> categoryService;

    @PostMapping("/add")
    public ResponseEntity<CategoryResponse> add(@RequestBody CategoryRequest categoryRequest){
        Category category = categoryService.create(categoryRequest);
        return ResponseEntity.ok().body(new CategoryResponse(category));
    }

    @PutMapping("/edit")
    public ResponseEntity<CategoryResponse> edit(@RequestBody CategoryRequest categoryRequest){
        Category category = categoryService.edit(categoryRequest);
        return ResponseEntity.ok().body(new CategoryResponse(category));
    }

    @GetMapping("/")
    public ResponseEntity<List<CategoryResponse>> all(){
        List<Category> category = categoryService.all();
        return ResponseEntity.ok().body(category.stream().map(CategoryResponse::new).collect(Collectors.toList()));
    }

    @GetMapping("/{tag}")
    public ResponseEntity<CategoryResponse> detail(@PathVariable String tag){
        Category category = categoryService.detail(tag);
        CategoryResponse categoryResponse = new CategoryResponse(category);
        return ResponseEntity.ok().body(categoryResponse);
    }

    @DeleteMapping("/{tag}")
    public ResponseEntity delete(@PathVariable String tag){
        categoryService.delete(tag);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/find/{text}")
    public ResponseEntity<List<FindResponse>> add(@PathVariable String text){
        List<Category> categories = categoryService.find(text);
        List<FindResponse> findResponses = categories.stream().flatMap(t -> t.getProducts().stream().map(FindResponse::new)).collect(Collectors.toList());
        return ResponseEntity.ok().body(findResponses);
    }
}
