package com.salbiyath.authservice.controller;

import com.salbiyath.authservice.dto.AuthRequest;
import com.salbiyath.authservice.dto.ServiceResponse;
import com.salbiyath.authservice.entity.UserCredential;
import com.salbiyath.authservice.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthService service;

    @Autowired
    public void setService(AuthService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<ServiceResponse> addNewUser(@RequestBody UserCredential user) {
        return service.saveUser(user);
    }

    @PostMapping("/token")
    public ResponseEntity<ServiceResponse> getToken(@RequestBody AuthRequest authRequest) {
        return service.generateToken(authRequest);
    }

    @GetMapping("/validate")
    public ResponseEntity<ServiceResponse> validateToken(@RequestParam("token") String token) {
        return service.validateToken(token);
    }
}
