package com.mongo.config;

import com.mongo.model.Category;
import com.mongo.repository.CategoryRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = CategoryRepository.class)
@Configuration
public class MongodbConfig {
}