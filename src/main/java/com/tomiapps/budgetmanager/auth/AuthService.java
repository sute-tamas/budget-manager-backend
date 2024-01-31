package com.tomiapps.budgetmanager.auth;

import com.tomiapps.budgetmanager.repository.UserRepository;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthService.class);

    @Getter
    @Setter(value = AccessLevel.PROTECTED, onMethod = @__({ @Autowired}))
    private JwtEncoder jwtEncoder;

    @Getter
    @Setter(value = AccessLevel.PROTECTED, onMethod = @__({ @Autowired}))
    private PasswordEncoder passwordEncoder;

    @Getter
    @Setter(value = AccessLevel.PROTECTED, onMethod = @__({ @Autowired}))
    private UserRepository userRepository;

    public String generateToken(Authentication authentication) {
        Instant now = Instant.now();

        String scope = authentication.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));

        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(now)
                .expiresAt(now.plus(10, ChronoUnit.HOURS))
                .subject(authentication.getName())
                .claim("scope", scope)
                .build();

        return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }

}