package com.ford.api.springboot.controllers;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ford.api.springboot.requests.LoginRequestBody;
import com.ford.api.springboot.services.LoginService;
import com.ford.api.springboot.utils.JwtTokenUtil;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("login")
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;
    private final JwtTokenUtil jwtTokenUtil;

    @PostMapping
    public ResponseEntity<?> verify(@RequestBody LoginRequestBody loginRequestBody) {
        try {
            loginService.verify(loginRequestBody);
            String token = jwtTokenUtil.generateToken(loginRequestBody.getUsername());
            Map<String,String> response = Map.of("accessToken", token);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
