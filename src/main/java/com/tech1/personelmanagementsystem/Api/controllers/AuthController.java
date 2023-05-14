/*
package com.tech1.personelmanagementsystem.Api.controllers;

import com.tech1.personelmanagementsystem.Core.Utilities.Auth.JWTTokenProvider;
import com.tech1.personelmanagementsystem.Core.Utilities.Auth.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {


    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JWTTokenProvider jwtTokenProvider;

    @PostMapping("/api/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        // Kullanıcı kimlik doğrulaması için Spring Security kullanılıyor
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password)
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Kimlik doğrulama başarılı olduğunda JWT token oluşturuluyor
        //String token = jwtTokenProvider.generateToken(authentication);

        // Token'i dönme işlemi
        //return ResponseEntity.ok(new JwtAuthenticationResponse(token));
        return null;
    }
}
*/
