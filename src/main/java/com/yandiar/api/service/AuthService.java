package com.yandiar.api.service;

import java.util.Collection;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Component
public class AuthService implements UserDetailsService {
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.debug("[SECURITY-SERVICE] check authentication");
        String password = "";
        try {
            log.debug("[SECURITY-SERVICE] validate password");
            if (username.equals("user")) {
                password = passwordEncoder.encode("user");
            }
        } catch (Exception e) {
            log.error("ERROR VALIDATE PASSWORD", e.getLocalizedMessage());
            e.printStackTrace();
        }

        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("REGISTERED"));

        return new User(username, password, authorities);
    }
}
