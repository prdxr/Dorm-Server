package ru.dorm.api.services;

public interface TokenService {
    String generateToken(String login);
    String parseToken(String token);
}
