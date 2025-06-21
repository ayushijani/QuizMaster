package com.ayushijani.user_service.service;

import com.ayushijani.user_service.model.User;
import com.ayushijani.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository ur;

    public UserDetails loadUserByUsername(String u) {
        User user = ur.findByUsername(u).orElseThrow();
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(),
                user.getRoles().stream().map(r -> new SimpleGrantedAuthority(r.getRoleName())).toList());
    }
}

