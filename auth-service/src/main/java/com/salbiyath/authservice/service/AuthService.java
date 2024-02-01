package com.salbiyath.authservice.service;

import com.salbiyath.authservice.dto.AuthRequest;
import com.salbiyath.authservice.dto.ServiceResponse;
import com.salbiyath.authservice.entity.UserCredential;
import com.salbiyath.authservice.repository.UserCredentialRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AuthService {

    private UserCredentialRepository repository;

    private PasswordEncoder passwordEncoder;

    private JwtService jwtService;

    private AuthenticationManager authenticationManager;

    @Autowired
    public void setRepository(JwtService jwtService, PasswordEncoder passwordEncoder, UserCredentialRepository repository,
                              AuthenticationManager authenticationManager) {
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
        this.repository = repository;
        this.authenticationManager = authenticationManager;


    }

    public ResponseEntity<ServiceResponse> saveUser(UserCredential credential) {
        try {
            credential.setPassword(passwordEncoder.encode(credential.getPassword()));
            UserCredential saved = repository.save(credential);
            log.info("Registration success {}", saved);
            return ResponseEntity.ok().body(ServiceResponse.builder()
                    .statusCode("00")
                    .status("Success")
                    .message("Registration success")
                    .data(saved)
                    .build());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.ok().body(ServiceResponse.builder()
                    .statusCode("01")
                    .status("Failed")
                    .message("Registration failed, please try again later!")
                    .build());
        }
    }

    public ResponseEntity<ServiceResponse> generateToken(AuthRequest authRequest) {
        try {
            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));

            String token = jwtService.generateToken(authRequest.getUsername());
            log.info("Generate token success with username {} : {}", authRequest.getUsername(), token);
            return ResponseEntity.ok().body(ServiceResponse.builder()
                    .statusCode("00")
                    .status("Success")
                    .message("Generate token success")
                    .data(token)
                    .build());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            String errMsg = "Generate token failed, please try again later!";
            if (e instanceof BadCredentialsException) {
                errMsg = "Bad credential, please try again later!";
            }
            return ResponseEntity.ok().body(ServiceResponse.builder()
                    .statusCode("02")
                    .status("Failed")
                    .message(errMsg)
                    .build());
        }
    }

    public ResponseEntity<ServiceResponse> validateToken(String token) {
        try {
            log.info("Validating token {}", token);
            jwtService.validateToken(token);
            return ResponseEntity.ok().body(ServiceResponse.builder()
                    .statusCode("00")
                    .status("Success")
                    .message("Token is valid")
                    .data(token)
                    .build());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.ok().body(ServiceResponse.builder()
                    .statusCode("03")
                    .status("Failed")
                    .message("Token is invalid, please try again later!")
                    .build());
        }

    }


}
