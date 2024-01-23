package com.example.restclientdemo.login;

import com.example.restclientdemo.security.JWTIssuer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class LoginController {

    private final JWTIssuer jwtIssuer;
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest){
        var token=jwtIssuer.issue(1L,loginRequest.getEmail(), List.of("admin"));
        return LoginResponse.builder().jwt(token).build();
    }
}
