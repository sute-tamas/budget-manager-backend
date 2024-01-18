package com.tomiapps.budgetmanager.controller;

import com.tomiapps.budgetmanager.dto.request.TransactionRequest;
import com.tomiapps.budgetmanager.dto.response.TransactionResponse;
import com.tomiapps.budgetmanager.entity.Transaction;
import com.tomiapps.budgetmanager.repository.TransactionRepository;
import com.tomiapps.budgetmanager.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/transactions")
public class TransactionController extends
        GenericController<Transaction, TransactionRequest, TransactionResponse, TransactionRepository, TransactionService> {

    // private static final Logger LOGGER = LoggerFactory.getLogger(TransactionController.class);

}
