package com.bohdan.updatestatisticbycache.controller;

import com.bohdan.updatestatisticbycache.jwt.AuthenticationResponse;
import com.bohdan.updatestatisticbycache.model.dto.LoginDTO;
import com.bohdan.updatestatisticbycache.model.dto.SignUpDTO;
import com.bohdan.updatestatisticbycache.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<AuthenticationResponse> signup(@RequestBody SignUpDTO signUpDTO) {
        return ResponseEntity.ok(authService.signup(signUpDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginDTO loginDTO) {
        return ResponseEntity.ok(authService.login(loginDTO));
    }
}
