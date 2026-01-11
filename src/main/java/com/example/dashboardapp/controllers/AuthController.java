package com.example.dashboardapp.controllers;

import com.example.dashboardapp.dto.AuthResponse;
import com.example.dashboardapp.dto.LoginRequest;
import com.example.dashboardapp.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;


    @PostMapping
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest){
      UserDetails userDetails = authenticationService.authenticate
                (loginRequest.getName(),
                loginRequest.getPassword())
              ;
      String tokenValue = authenticationService.generateToken(userDetails);


    AuthResponse authResponse =  AuthResponse.builder()
              .token(tokenValue)
              .expiresIn(86400) //24 timer
              .build();

        return ResponseEntity.ok(authResponse);
    }



}
