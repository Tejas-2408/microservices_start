package com.restapi.database.service.impl;

import com.restapi.database.entity.User;
import com.restapi.database.repository.UserRepository;
import com.restapi.database.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
}
