package com.tomiapps.budgetmanager.dto.response;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubcategoryResponse {

    private Long id;

    private String name;

    private CategoryResponse category;

}
