package ru.dorm.api.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.dorm.api.dao.UserDAO;
import ru.dorm.api.dto.login.LoginRequest;
import ru.dorm.api.dto.login.LoginResponse;
import ru.dorm.api.dto.register.RegisterRequest;
import ru.dorm.api.dto.register.RegisterResponse;
import ru.dorm.api.entities.User;
import ru.dorm.api.repositories.UserRepository;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final UserRepository userRepository;
    private final TokenService tokenService;
    private final UserDAO userDAO;
    private final PasswordEncoder passwordEncoder;

    @Override
    public RegisterResponse registration(RegisterRequest registerRequest) {
        String login = registerRequest.getLogin();
        if (userDAO.findByLogin(login) != null){
            return new RegisterResponse(null, 409);
        }
        if (login == null) {
            return new RegisterResponse(null, 406);
        }
        String password = registerRequest.getPassword(); //encoder!!!!!!11
        int dorm_id = registerRequest.getDorm_id();
        int role_id = registerRequest.getRole_id();

        User newUser = User.builder()
                .login(login)
                .password(passwordEncoder.encode(password))
                .dorm_id(dorm_id)
                .role_id(role_id)
                .build();


        userRepository.save(newUser);
        return new RegisterResponse(tokenService.generateToken(login), 200);
    }
    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        String login = loginRequest.getLogin();
        String password = loginRequest.getPassword();

        if (userDAO.findByLogin(login) == null) {
            return new LoginResponse(null, 409); //нет логина в бд
        }
        User user = userDAO.findByLogin(login);
        if (!passwordEncoder.matches(password, user.getPassword())) {
            return new LoginResponse(null, 406); //логин или пароль неверны
        }
        String token = tokenService.generateToken(login);
        return new LoginResponse(token, 200);
    }
}
