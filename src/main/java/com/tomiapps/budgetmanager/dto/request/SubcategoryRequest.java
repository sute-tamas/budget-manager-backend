package com.tomiapps.budgetmanager.dto.request;

import lombok.Data;

@Data
public class SubcategoryRequest {

    private Long id;

    private String name;

    private Long categoryId;

}
