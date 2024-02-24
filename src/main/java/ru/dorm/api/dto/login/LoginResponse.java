package ru.dorm.api.dto.login;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {
    private String access_token;
    private int httpStatus;
}
