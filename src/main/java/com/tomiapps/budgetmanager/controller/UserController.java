package com.tomiapps.budgetmanager.controller;

import com.tomiapps.budgetmanager.dto.request.UserRequest;
import com.tomiapps.budgetmanager.dto.response.UserResponse;
import com.tomiapps.budgetmanager.entity.User;
import com.tomiapps.budgetmanager.repository.UserRepository;
import com.tomiapps.budgetmanager.service.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class UserController extends GenericController<User, UserRequest, UserResponse, UserRepository, UserService> {

}
