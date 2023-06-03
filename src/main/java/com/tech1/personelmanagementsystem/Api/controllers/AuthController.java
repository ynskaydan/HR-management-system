
package com.tech1.personelmanagementsystem.Api.controllers;
import com.tech1.personelmanagementsystem.Business.abstracts.AuthenticationService;
import com.tech1.personelmanagementsystem.Core.Entities.AuthenticationRequest;
import com.tech1.personelmanagementsystem.Core.Entities.AuthenticationResponse;
import com.tech1.personelmanagementsystem.Core.Entities.RegisterRequest;
import com.tech1.personelmanagementsystem.Core.Utilities.Results.*;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    private final AuthenticationService authService;


    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest authenticationRequest) {
       return ResponseEntity.ok(authService.authenticate(authenticationRequest));
    }
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest registerRequest){

        return ResponseEntity.ok(authService.register(registerRequest));



    }
}

