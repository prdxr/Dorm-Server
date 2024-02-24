package ru.dorm.api.dto.register;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterResponse {
    private String access_token;
    private int httpStatus;
}
