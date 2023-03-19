package com.example.bloggingapplication.security;

import com.example.bloggingapplication.entities.User;
import com.example.bloggingapplication.exceptions.ApiException;
import com.example.bloggingapplication.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = this.userRepository.findByEmail(userName).orElseThrow(() -> new ApiException("User not found with " + userName + " this email id !!"));
        return user;
    }
}
