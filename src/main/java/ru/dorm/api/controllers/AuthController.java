package ru.dorm.api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dorm.api.dto.register.RegisterRequest;
import ru.dorm.api.dto.register.RegisterResponse;
import ru.dorm.api.services.AuthService;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    @PostMapping("/reg")
    public RegisterResponse registration (@RequestBody RegisterRequest registerRequest){
        RegisterResponse registerResponse = authService.registration(registerRequest);
        return registerResponse;
    }
}
