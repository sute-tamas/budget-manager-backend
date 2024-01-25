package com.tomiapps.budgetmanager.controller;

import com.tomiapps.budgetmanager.dto.request.UserRequest;
import com.tomiapps.budgetmanager.dto.response.UserResponse;
import com.tomiapps.budgetmanager.entity.User;
import com.tomiapps.budgetmanager.repository.UserRepository;
import com.tomiapps.budgetmanager.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/users")
public class UserController extends GenericController<User, UserRequest, UserResponse, UserRepository, UserService> {

}
