package com.tomiapps.budgetmanager.service;

import com.tomiapps.budgetmanager.dto.request.SubcategoryRequest;
import com.tomiapps.budgetmanager.dto.response.CategoryResponse;
import com.tomiapps.budgetmanager.dto.response.SubcategoryResponse;
import com.tomiapps.budgetmanager.entity.Category;
import com.tomiapps.budgetmanager.entity.Subcategory;
import com.tomiapps.budgetmanager.repository.CategoryRepository;
import com.tomiapps.budgetmanager.repository.ItemRepository;
import com.tomiapps.budgetmanager.repository.SubcategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.Optional;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubcategoryService extends
        GenericService<Subcategory, SubcategoryRequest, SubcategoryResponse, SubcategoryRepository> {

    @Getter
    @Setter(value = AccessLevel.PROTECTED, onMethod = @__({ @Autowired}))
    private CategoryRepository categoryRepository;

    @Getter
    @Setter(value = AccessLevel.PROTECTED, onMethod = @__({ @Autowired}))
    private SubcategoryRepository subcategoryRepository;

    @Getter
    @Setter(value = AccessLevel.PROTECTED, onMethod = @__({ @Autowired}))
    private ItemRepository itemRepository;

    @Override
    protected SubcategoryResponse convertResponse(Subcategory model) {
        return new SubcategoryResponse(
                model.getId(),
                model.getName(),
                new CategoryResponse(
                        model.getCategory().getId(),
                        model.getCategory().getName()
                )
        );
    }

    @Override
    protected Subcategory convertRequest(SubcategoryRequest request) {
        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new EntityNotFoundException("Category not found with id: " + request.getCategoryId()));

        Optional<Subcategory> subcategory = (request.getId() == null) ?
                Optional.empty() : Optional.of(subcategoryRepository.findById(request.getId()).orElseThrow(
                        () -> new EntityNotFoundException("Subcategory not found with id: " + request.getId())));

        return subcategory.orElseGet(() ->
                new Subcategory(
                        null,
                        request.getName().toLowerCase(),
                        category,
                        null)
        );
    }
}
