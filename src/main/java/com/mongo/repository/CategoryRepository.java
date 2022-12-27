package com.mongo.repository;

import com.mongo.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends MongoRepository<Category,Integer> {
//    List<Category> findByIdIn(List<Integer> ids);
    List<String> findByIdIn(List<Integer> ids);

    List<Category> findModelByIdIn(List<Integer> ids);
}
