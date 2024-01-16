package com.tomiapps.budgetmanager.dto.request;
import lombok.Data;
import lombok.NonNull;

@Data
public class ItemRequest {

    @NonNull
    private Long id;

    private String name;

    private SubcategoryRequest subcategory;

}

