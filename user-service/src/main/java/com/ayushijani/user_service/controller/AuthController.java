package com.ayushijani.user_service.controller;

import com.ayushijani.user_service.dto.JwtResponse;
import com.ayushijani.user_service.dto.LoginRequest;
import com.ayushijani.user_service.security.JwtUtil;
import com.ayushijani.user_service.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthenticationManager am;

    @Autowired
    JwtUtil ju;

    @Autowired
    CustomUserDetailsService uds;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest r) {
        Authentication auth = am.authenticate(
                new UsernamePasswordAuthenticationToken(r.getUsername(), r.getPassword()));
        String token = ju.generateToken((UserDetails) auth.getPrincipal());
        return ResponseEntity.ok(new JwtResponse(token));
    }
}

