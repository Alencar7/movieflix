package com.movieFlix.moviefliex.controller;

import com.movieFlix.moviefliex.controller.request.CategoryRequest;
import com.movieFlix.moviefliex.controller.response.CategoryResponse;
import com.movieFlix.moviefliex.entity.Category;
import com.movieFlix.moviefliex.mapper.CategoryMapper;
import com.movieFlix.moviefliex.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("movieflix/category")
@RequiredArgsConstructor //lombok
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getAllCategories() {
        List<CategoryResponse> categories = categoryService.findAll()
                .stream()
                .map(CategoryMapper::toCategoryResponse)
                .toList();

        return ResponseEntity.ok(categories);
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> saveCategory(@Valid @RequestBody CategoryRequest request) {
        Category newCategory = CategoryMapper.toCategory(request);
        Category savedCategory = categoryService.saveCategory(newCategory);
        //return CategoryMapper.toCategoryResponse(savedCategory);
        return ResponseEntity
                .status(HttpStatus.CREATED).body(CategoryMapper.toCategoryResponse(savedCategory));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getByCategoryId(@PathVariable Long id) {
        return categoryService.findById(id)
                .map(category -> ResponseEntity.ok(CategoryMapper.toCategoryResponse(category)))
                .orElse(ResponseEntity.notFound().build());
        // Optional<Category> optionalCategory = categoryService.findById(id);
        //if (optionalCategory.isPresent()) {
        //    return CategoryMapper.toCategoryResponse(optionalCategory.get());
        //}
        //return null;

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteByCategoryId(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
