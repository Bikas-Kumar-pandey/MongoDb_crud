package com.mongo.service;

import com.mongo.dto.CategoryRequest;
import com.mongo.dto.CategoryResponse;
import com.mongo.model.Category;
import com.mongo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepo;

    public Category saveCategory(CategoryRequest request) throws Exception {

        if (categoryRepo.existsById(request.getId())) {
            throw new Exception("Id Already Exits");
        }
        Category category = new Category();
        category.setId(request.getId());
        category.setModel(request.getModel());
        category.setDescription(request.getDescription());
        return categoryRepo.save(category);
    }

    public CategoryResponse getCategory(int id) throws Exception {
        if (!categoryRepo.existsById(id)) {
            throw new Exception("No Data present By given id :" + id);
        }
        Optional<Category> byId = categoryRepo.findById(id);
        Category category = byId.get();
        CategoryResponse response = new CategoryResponse();
        response.setDescription(category.getDescription());
        response.setModel(category.getModel());
        return response;
    }

    public Set<CategoryResponse> getAllCategory() {
        List<Category> all = categoryRepo.findAll();
        Set<CategoryResponse> responses = new LinkedHashSet<>();

        for (Category category : all) {
            CategoryResponse response = new CategoryResponse();
            response.setId(category.getId());
            response.setModel(category.getModel());
            response.setDescription(category.getDescription());
            responses.add(response);
        }
        return responses;
    }

    public String daletedCatageory(int id) throws Exception {
        if (!categoryRepo.existsById(id)) {
            throw new Exception("NO Data Present by given id: " + id);
        }
        categoryRepo.deleteById(id);
        return "Deleted Data of id: " + id;
    }

    public Category updateCategory(CategoryRequest request, int id) throws Exception {
        if (!categoryRepo.existsById(id)) {
            throw new Exception("No Values present by given id :" + id);
        }
        Category category = categoryRepo.findById(id).get();
        category.setDescription(request.getDescription());
        category.setModel(request.getModel());
        return categoryRepo.save(category);
    }

}
