package com.mongo.controller;

import com.mongo.dto.CategoryRequest;
import com.mongo.dto.CategoryResponse;
import com.mongo.model.Category;
import com.mongo.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
@Slf4j
@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/category")
    public Category saveCategory(@RequestBody CategoryRequest request) throws Exception {
        log.debug("----->>>>>>>Im here");
        log.info("Info Bikas");
        return categoryService.saveCategory(request);
    }

    @GetMapping("/category/{id}")
    public CategoryResponse getCategory(@PathVariable int id) throws Exception {
        return categoryService.getCategory(id);
    }

    @GetMapping("/allCategory")
    public Set<CategoryResponse> getAllCategory() {
        return categoryService.getAllCategory();
    }

    @DeleteMapping("/category/{id}")
    public String daletedCatageory(@PathVariable int id) throws Exception {
        return categoryService.daletedCatageory(id);
    }

    @PutMapping("/category/{id}")
    public Category updateCategory(@RequestBody CategoryRequest request, @PathVariable int id) throws Exception {
        return categoryService.updateCategory(request, id);
    }


}
