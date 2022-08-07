package com.ford.api.springboot.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ford.api.springboot.requests.LoginRequestBody;
import com.ford.api.springboot.services.LoginService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("login")
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;

    @PostMapping
    public ResponseEntity<?> verify(@RequestBody LoginRequestBody loginRequestBody) {
        try {
            loginService.verify(loginRequestBody);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
