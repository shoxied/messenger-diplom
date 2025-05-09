package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.example.entity.Users;
import org.example.repo.UserRepository;
import org.example.service.AuthenticationService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.OffsetDateTime;

import static org.example.entity.Roles.USER;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtEncoder jwtEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public String register(String email, String phone_number, String first_name, String last_name, String password) throws BadRequestException {
        if (userRepository.findByEmail(email) == null){
            throw new BadRequestException("the user with the specified name already exists");
        }

        Users user = Users.builder()
                .email(email)
                .phone_number(phone_number)
                .first_name(first_name)
                .last_name(last_name)
                .role(USER)
                .password(passwordEncoder.encode(password))
                .create_date(OffsetDateTime.now())
                .build();

        userRepository.save(user);

        return generateToken(email, USER.name());
    }

    private String generateToken(String email, String scope) {
        Instant now = Instant.now();
        long expiry = 100000L;
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiry))
                .subject(email)
                .claim("scope", scope)
                .build();
        return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }

    private String authenticate() {
    }
}
