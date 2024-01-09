package com.tomiapps.budgetmanager.dto.response;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemResponse {

    private Long id;

    private String name;

    private SubcategoryResponse subcategory;

}
