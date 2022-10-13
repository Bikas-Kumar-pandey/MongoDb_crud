package com.mongo.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Document(collection = "category")
public class Category {
    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String model;
    private String description;
}
