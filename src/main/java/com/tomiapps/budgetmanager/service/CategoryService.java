package com.tomiapps.budgetmanager.service;

import com.tomiapps.budgetmanager.dto.request.CategoryRequest;
import com.tomiapps.budgetmanager.dto.response.CategoryResponse;
import com.tomiapps.budgetmanager.entity.Category;
import com.tomiapps.budgetmanager.repository.CategoryRepository;
import com.tomiapps.budgetmanager.repository.SubcategoryRepository;
import java.util.Optional;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends
        GenericService<Category, CategoryRequest, CategoryResponse, CategoryRepository> {

    @Getter
    @Setter(value = AccessLevel.PROTECTED, onMethod = @__({ @Autowired}))
    private SubcategoryRepository subcategoryRepository;

    @Getter
    @Setter(value = AccessLevel.PROTECTED, onMethod = @__({ @Autowired}))
    private CategoryRepository categoryRepository;

    @Override
    protected CategoryResponse convertResponse(Category model) {
        return new CategoryResponse(
                model.getId(),
                model.getName()
        );
    }

    @Override
    protected Category convertRequest(CategoryRequest request) {
        Optional<Category> category = (request.getId() == null) ?
                Optional.empty() : categoryRepository.findById(request.getId());

        return category.orElseGet(() -> new Category(
                null,
                request.getName().toLowerCase(),
                null)
        );
    }
}
