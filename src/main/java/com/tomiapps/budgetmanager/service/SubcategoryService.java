package com.tomiapps.budgetmanager.service;

import com.tomiapps.budgetmanager.dto.request.SubcategoryRequest;
import com.tomiapps.budgetmanager.dto.response.CategoryResponse;
import com.tomiapps.budgetmanager.dto.response.SubcategoryResponse;
import com.tomiapps.budgetmanager.entity.Category;
import com.tomiapps.budgetmanager.entity.Item;
import com.tomiapps.budgetmanager.entity.Subcategory;
import com.tomiapps.budgetmanager.repository.CategoryRepository;
import com.tomiapps.budgetmanager.repository.ItemRepository;
import com.tomiapps.budgetmanager.repository.SubcategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
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
        Category category = categoryRepository.findById(request.getCategory().getId())
                .orElseThrow(() -> new EntityNotFoundException("Category not found with id: " + request.getCategory().getId()));
        List<Item> items = itemRepository.findBySubcategoryId(request.getId());
        return new Subcategory(
                request.getId(),
                request.getName(),
                category,
                items
        );
    }
}
