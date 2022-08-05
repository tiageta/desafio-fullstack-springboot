package com.ford.api.springboot.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ford.api.springboot.domains.User;
import com.ford.api.springboot.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> listAll() {
        return userRepository.findAll();
    }
}
