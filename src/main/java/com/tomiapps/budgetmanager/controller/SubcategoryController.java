package com.tomiapps.budgetmanager.controller;

import com.tomiapps.budgetmanager.dto.request.SubcategoryRequest;
import com.tomiapps.budgetmanager.dto.response.SubcategoryResponse;
import com.tomiapps.budgetmanager.entity.Subcategory;
import com.tomiapps.budgetmanager.repository.SubcategoryRepository;
import com.tomiapps.budgetmanager.service.SubcategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/subcategories")
public class SubcategoryController extends GenericController<Subcategory, SubcategoryRequest, SubcategoryResponse, SubcategoryRepository, SubcategoryService> {

}
