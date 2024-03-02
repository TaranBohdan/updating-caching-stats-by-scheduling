package com.bohdan.updatestatisticbycache.service;

import com.bohdan.updatestatisticbycache.exception.UserAlreadyRegisteredException;
import com.bohdan.updatestatisticbycache.jwt.AuthenticationResponse;
import com.bohdan.updatestatisticbycache.jwt.JwtService;
import com.bohdan.updatestatisticbycache.model.dto.LoginDTO;
import com.bohdan.updatestatisticbycache.model.dto.SignUpDTO;
import com.bohdan.updatestatisticbycache.model.entity.User;
import com.bohdan.updatestatisticbycache.model.enumeration.Role;
import com.bohdan.updatestatisticbycache.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse signup(SignUpDTO signUpDTO) {

        if (userRepository.findByEmail(signUpDTO.email()).isPresent()) {
            throw new UserAlreadyRegisteredException("This email is already registered. Please use another.");
        }

        var validEmail = "[a-z0-9.]+@[a-z0-9.]+\\.[a-z]+";

        if (!signUpDTO.email().matches(validEmail)) {
            throw new BadCredentialsException("Your email is invalid. Please try to enter another.");
        }

        var user = User.builder()
                .email(signUpDTO.email())
                .password(passwordEncoder.encode(signUpDTO.password()))
                .role(Role.USER)
                .build();

        userRepository.insert(user);

        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse login(LoginDTO loginDTO) {

        var email = loginDTO.email();
        var password = loginDTO.password();

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, password)
            );
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("The email address or password is incorrect. Please retry...");
        }

        var user = userRepository.findByEmail(email).orElseThrow();

        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

}
