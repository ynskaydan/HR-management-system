package com.tech1.personelmanagementsystem.Business.concretes;

import com.tech1.personelmanagementsystem.Business.abstracts.AuthenticationService;
import com.tech1.personelmanagementsystem.Core.DataAccess.UserDao;
import com.tech1.personelmanagementsystem.Core.Entities.AuthenticationRequest;
import com.tech1.personelmanagementsystem.Core.Entities.AuthenticationResponse;
import com.tech1.personelmanagementsystem.Core.Entities.RegisterRequest;
import com.tech1.personelmanagementsystem.Core.Entities.User;
import com.tech1.personelmanagementsystem.Core.Utilities.Auth.JwtService;
import com.tech1.personelmanagementsystem.Core.Utilities.Results.ErrorResult;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthManager implements AuthenticationService {
    @Autowired
    private  UserDao userDao;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private  AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponse register(RegisterRequest registerRequest) {
        User user = User.builder()
                .username(registerRequest.getEmail())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(registerRequest.getRole())
                .build();
        userDao.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .success("true")
                .token(jwtToken)
                .build();
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword())
        );
        User user = userDao.getUserByEmail(authenticationRequest.getEmail());

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .success("true")
                .token(jwtToken)
                .build();
    }
}
