package com.ConnectWise.services.impl;

import com.ConnectWise.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityCustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // ap-ne user ko load kar-ana hai
        return userRepo.findByEmail(username)
                .orElseThrow(()-> new UsernameNotFoundException("User not found with email: " + username));
    }
}
