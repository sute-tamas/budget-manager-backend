package com.tomiapps.budgetmanager.controller;

import com.tomiapps.budgetmanager.dto.request.ItemRequest;
import com.tomiapps.budgetmanager.dto.response.ItemResponse;
import com.tomiapps.budgetmanager.entity.Item;
import com.tomiapps.budgetmanager.repository.ItemRepository;
import com.tomiapps.budgetmanager.service.ItemService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/items")
public class ItemController extends GenericController<Item, ItemRequest, ItemResponse, ItemRepository, ItemService> {

}
