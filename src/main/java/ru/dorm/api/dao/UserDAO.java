package ru.dorm.api.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dorm.api.entities.User;
import ru.dorm.api.repositories.UserRepository;

@Service
@RequiredArgsConstructor
public class UserDAO {
    private final UserRepository userRepository;
    public User findByLogin(String login){
        return userRepository.findByLogin(login);
    }
}
