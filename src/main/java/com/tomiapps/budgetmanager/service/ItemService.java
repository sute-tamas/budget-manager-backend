package com.tomiapps.budgetmanager.service;

import com.tomiapps.budgetmanager.dto.request.ItemRequest;
import com.tomiapps.budgetmanager.dto.response.CategoryResponse;
import com.tomiapps.budgetmanager.dto.response.ItemResponse;
import com.tomiapps.budgetmanager.dto.response.SubcategoryResponse;
import com.tomiapps.budgetmanager.entity.Item;
import com.tomiapps.budgetmanager.entity.Subcategory;
import com.tomiapps.budgetmanager.entity.Transaction;
import com.tomiapps.budgetmanager.repository.ItemRepository;
import com.tomiapps.budgetmanager.repository.SubcategoryRepository;
import com.tomiapps.budgetmanager.repository.TransactionRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService extends GenericService<Item, ItemRequest, ItemResponse, ItemRepository> {

    @Getter
    @Setter(value = AccessLevel.PROTECTED, onMethod = @__({ @Autowired}))
    private SubcategoryRepository subcategoryRepository;

    @Getter
    @Setter(value = AccessLevel.PROTECTED, onMethod = @__({ @Autowired}))
    private TransactionRepository transactionRepository;

    @Override
    protected ItemResponse convertResponse(Item model) {
        return new ItemResponse(
                model.getId(),
                model.getName(),
                new SubcategoryResponse(
                        model.getSubcategory().getId(),
                        model.getSubcategory().getName(),
                        new CategoryResponse(
                                model.getSubcategory().getCategory().getId(),
                                model.getSubcategory().getCategory().getName()
                        )
                )
        );
    }

    @Override
    protected Item convertRequest(ItemRequest request) {
        Subcategory subcategory = subcategoryRepository.findById(request.getSubcategory().getId())
                .orElseThrow(() -> new EntityNotFoundException("Subcategory not found with id: " + request.getSubcategory().getId()));
        List<Transaction> transactions = transactionRepository.findByItemId(request.getId());

        return new Item(
                request.getId(),
                request.getName(),
                subcategory,
                transactions
        );
    }
}
