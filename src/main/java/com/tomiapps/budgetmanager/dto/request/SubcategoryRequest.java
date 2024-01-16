package com.tomiapps.budgetmanager.dto.request;

import lombok.Data;
import lombok.NonNull;

@Data
public class SubcategoryRequest {

    @NonNull
    private Long id;

    private String name;

    private CategoryRequest category;

}
