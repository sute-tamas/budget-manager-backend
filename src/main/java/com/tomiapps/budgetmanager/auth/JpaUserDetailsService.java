package com.tomiapps.budgetmanager.auth;

import com.tomiapps.budgetmanager.repository.UserRepository;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class JpaUserDetailsService implements UserDetailsService {

    @Getter
    @Setter(value = AccessLevel.PROTECTED, onMethod = @__({ @Autowired}))
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findByUsername(username)
                .map(AuthUser::new)
                .orElseThrow(() -> new UsernameNotFoundException("User name not found: " + username));
    }
}
