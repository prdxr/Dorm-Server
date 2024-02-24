package ru.dorm.api.services;

import ru.dorm.api.dto.login.LoginRequest;
import ru.dorm.api.dto.login.LoginResponse;
import ru.dorm.api.dto.register.RegisterRequest;
import ru.dorm.api.dto.register.RegisterResponse;

public interface AuthService {

    RegisterResponse registration(RegisterRequest registerRequest);

    LoginResponse login(LoginRequest loginResponse);
}
