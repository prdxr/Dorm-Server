package ru.dorm.api.dto.register;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class RegisterRequest {
    private String login;
    private String password;
    private int dorm_id;
    private int role_id;
}
