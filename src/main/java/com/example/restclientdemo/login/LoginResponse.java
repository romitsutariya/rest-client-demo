package com.example.restclientdemo.login;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponse {
    String jwt;
}
