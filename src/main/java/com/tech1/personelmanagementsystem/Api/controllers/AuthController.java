
package com.tech1.personelmanagementsystem.Api.controllers;
import com.tech1.personelmanagementsystem.Business.abstracts.UserService;
import com.tech1.personelmanagementsystem.Core.Utilities.Results.ErrorResult;
import com.tech1.personelmanagementsystem.Core.Utilities.Results.Result;
import com.tech1.personelmanagementsystem.Core.Utilities.Results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth/")
public class AuthController {

    private UserService userService;
    private AuthenticationManager authenticationManager;

    @Autowired
    public AuthController(UserService userService){
        super();
        this.userService = userService;
    }



    @PostMapping("/login")
    public Result login(@RequestParam("username") String username, @RequestParam("password") String password) {
        try {

            // Kullanıcı adı ve şifre ile authentication token oluştur
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);

            // AuthenticationManager kullanarak kimlik doğrulama yap
            Authentication authentication = authenticationManager.authenticate(authenticationToken);

            // Kimlik doğrulaması başarılı olduysa, SecurityContextHolder üzerinde authentication nesnesini ayarla
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // Başarılı giriş durumunda uygun bir yanıt döndür
            return new SuccessResult("Succesfully Login");
        } catch (AuthenticationException e) {
            // Başarısız giriş durumunda uygun bir yanıt döndür
            return new ErrorResult("Error accured while validation identity " + e.getMessage());
            //return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Kimlik doğrulama hatası: " + e.getMessage());
        }
    }}

/*    @PostMapping("/api/login")
    public Result login(@RequestBody LoginRequest loginRequest) {
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
    }*/


