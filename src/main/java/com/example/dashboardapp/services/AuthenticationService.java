package com.example.dashboardapp.services;

import org.springframework.security.core.userdetails.UserDetails;

public interface AuthenticationService {


    UserDetails authenticate(String name, String password);
    String generateToken(UserDetails userDetails);
    UserDetails validateToken(String token);



}
