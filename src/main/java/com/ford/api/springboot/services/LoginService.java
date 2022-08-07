package com.ford.api.springboot.services;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ford.api.springboot.domains.User;
import com.ford.api.springboot.requests.LoginRequestBody;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final UserService userService;

    public void verify(LoginRequestBody loginRequestBody) {
        String username = loginRequestBody.getUsername();
        String password = loginRequestBody.getPassword();
        if(username.isEmpty() || password.isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username and password are required");

        User foundUser = userService.listAll().stream()
                        .filter(user -> username.equals(user.getUsername()))
                        .findAny()
                        .orElse(null);
        if(foundUser == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No user found");
    
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        boolean match = passwordEncoder.matches(password, foundUser.getPassword());
        if(!match)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Wrong credentials");
    }
}
