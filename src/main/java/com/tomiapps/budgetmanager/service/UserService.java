package com.tomiapps.budgetmanager.service;

import com.tomiapps.budgetmanager.dto.request.UserRequest;
import com.tomiapps.budgetmanager.dto.response.UserResponse;
import com.tomiapps.budgetmanager.entity.User;
import com.tomiapps.budgetmanager.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.Optional;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService extends GenericService<User, UserRequest, UserResponse, UserRepository> {

    @Getter
    @Setter(value = AccessLevel.PROTECTED, onMethod = @__({ @Autowired}))
    private UserRepository userRepository;

    @Getter
    @Setter(value = AccessLevel.PROTECTED, onMethod = @__({ @Autowired}))
    private PasswordEncoder passwordEncoder;

    @Override
    protected UserResponse convertResponse(User model) {
        return new UserResponse(
                model.getId(),
                model.getUsername(),
                model.getEmail(),
                model.getFirstName(),
                model.getLastName()
        );
    }

    @Override
    protected User convertRequest(UserRequest request) {
        Optional<User> user = (request.getId() == null) ?
                Optional.empty() : Optional.of(userRepository.findById(request.getId()).orElseThrow(
                        () -> new EntityNotFoundException("User not found with id: " + request.getId())));

        return user.orElseGet(() -> new User(
                null,
                request.getUserName(),
                request.getEmail(),
                passwordEncoder.encode(request.getPassword()),
                request.getFirstName(),
                request.getLastName(),
                null
        ));
    }
}
