package com.feig.controller.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CategoryRequest implements Serializable {
    private int id;
    private String categoryName;
    private String description;
}
