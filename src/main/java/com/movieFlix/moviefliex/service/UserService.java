package com.movieFlix.moviefliex.service;

import com.movieFlix.moviefliex.entity.User;
import com.movieFlix.moviefliex.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder; //criptografado

    public User save(User user) {
        String password = user.getPassword(); //senha setada
        user.setPassword(passwordEncoder.encode(password)); //de forma criptografada :)
        return userRepository.save(user);
    }
}
