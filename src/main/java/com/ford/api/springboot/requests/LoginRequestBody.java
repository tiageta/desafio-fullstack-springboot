package com.ford.api.springboot.requests;

import lombok.Data;

@Data
public class LoginRequestBody {
    private String username;
    private String password;
}
