package com.mongo.dto;

import lombok.Data;

@Data
public class CategoryRequest {
    private int id;
    private String model;
    private String description;
}
