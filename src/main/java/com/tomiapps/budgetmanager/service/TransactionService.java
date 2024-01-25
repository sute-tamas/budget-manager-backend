package com.tomiapps.budgetmanager.service;

import com.tomiapps.budgetmanager.dto.request.TransactionRequest;
import com.tomiapps.budgetmanager.dto.response.ItemResponse;
import com.tomiapps.budgetmanager.dto.response.SubcategoryResponse;
import com.tomiapps.budgetmanager.dto.response.TransactionResponse;
import com.tomiapps.budgetmanager.dto.response.UserResponse;
import com.tomiapps.budgetmanager.entity.Item;
import com.tomiapps.budgetmanager.entity.Transaction;
import com.tomiapps.budgetmanager.entity.User;
import com.tomiapps.budgetmanager.repository.ItemRepository;
import com.tomiapps.budgetmanager.repository.TransactionRepository;
import com.tomiapps.budgetmanager.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.Optional;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService extends
        GenericService<Transaction, TransactionRequest, TransactionResponse, TransactionRepository> {

    @Getter
    @Setter(value = AccessLevel.PROTECTED, onMethod = @__({ @Autowired}))
    private ItemRepository itemRepository;

    @Getter
    @Setter(value = AccessLevel.PROTECTED, onMethod = @__({ @Autowired}))
    private TransactionRepository transactionRepository;

    @Getter
    @Setter(value = AccessLevel.PROTECTED, onMethod = @__({ @Autowired}))
    private UserRepository userRepository;

    @Override
    protected TransactionResponse convertResponse(Transaction model) {
        return new TransactionResponse(
                model.getId(),
                new ItemResponse(
                        model.getItem().getId(),
                        model.getItem().getName(),
                        new SubcategoryResponse()
                ),
                model.getValue(),
                new UserResponse(
                        model.getUser().getId(),
                        model.getUser().getUsername(),
                        model.getUser().getEmail(),
                        model.getUser().getFirstName(),
                        model.getUser().getLastName()
                ),
                model.getTimestamp()
        );
    }

    @Override
    protected Transaction convertRequest(TransactionRequest request) {
        Item item = itemRepository.findById(request.getItemId())
                .orElseThrow(() -> new EntityNotFoundException("Item not found with id: " + request.getItemId()));
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + request.getUserId()));

        Optional<Transaction> transaction = (request.getId() == null) ?
                Optional.empty() : Optional.of(transactionRepository.findById(request.getId()).orElseThrow(
                        () -> new EntityNotFoundException("Transaction not found with id: " + request.getId())));

        return transaction.orElseGet(() -> new Transaction(
                null,
                item,
                request.getValue(),
                user,
                (request.getTimestamp()) == null ? LocalDateTime.now() : request.getTimestamp())
        );
    }

}
