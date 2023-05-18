package com.tech1.personelmanagementsystem.Business.abstracts;

import com.tech1.personelmanagementsystem.Core.Entities.AuthenticationRequest;
import com.tech1.personelmanagementsystem.Core.Entities.AuthenticationResponse;
import com.tech1.personelmanagementsystem.Core.Entities.RegisterRequest;
import com.tech1.personelmanagementsystem.Core.Utilities.Results.Result;

public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest registerRequest);
    AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest);
}
