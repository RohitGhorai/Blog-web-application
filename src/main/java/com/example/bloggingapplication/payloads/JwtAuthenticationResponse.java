package com.example.bloggingapplication.payloads;

import lombok.Data;

@Data
public class JwtAuthenticationResponse {
    private String token;
}
