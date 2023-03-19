package com.example.bloggingapplication.payloads;

import lombok.Data;

@Data
public class JwtAuthenticationRequest {
    private String userName;
    private String password;
}
