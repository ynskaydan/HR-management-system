
package com.tech1.personelmanagementsystem.Api.controllers;
import com.tech1.personelmanagementsystem.Business.abstracts.AuthenticationService;
import com.tech1.personelmanagementsystem.Core.Entities.AuthenticationRequest;
import com.tech1.personelmanagementsystem.Core.Entities.AuthenticationResponse;
import com.tech1.personelmanagementsystem.Core.Entities.RegisterRequest;
import com.tech1.personelmanagementsystem.Core.Utilities.Results.*;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authService;


    @PostMapping("/login")
    public Result login(@RequestBody AuthenticationRequest authenticationRequest) {
       AuthenticationResponse response = authService.authenticate(authenticationRequest);
       return new SuccessDataResult<String>(response.getToken(),"Succesfully authenticated!");
    }
    @PostMapping("/register")
    public Result register(@RequestBody RegisterRequest registerRequest){
        AuthenticationResponse response = authService.register(registerRequest);
        return new SuccessDataResult<String>(response.getToken(),"Succesfully registered!");


    }
}

