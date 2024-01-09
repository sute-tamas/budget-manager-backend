package com.tomiapps.budgetmanager.dto.request;

import lombok.Data;

@Data
public class ItemRequest {

    private Long id;

    private String name;

    private SubcategoryRequest subcategory;

}

