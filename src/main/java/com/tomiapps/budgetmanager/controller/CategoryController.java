package com.tomiapps.budgetmanager.controller;

import com.tomiapps.budgetmanager.dto.request.CategoryRequest;
import com.tomiapps.budgetmanager.dto.response.CategoryResponse;
import com.tomiapps.budgetmanager.entity.Category;
import com.tomiapps.budgetmanager.repository.CategoryRepository;
import com.tomiapps.budgetmanager.service.CategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class CategoryController extends GenericController<Category, CategoryRequest, CategoryResponse, CategoryRepository, CategoryService> {

}
