package com.salbiyath.gatewayservice.exception;

import com.salbiyath.gatewayservice.dto.ServiceResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends Exception {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ServiceResponse> handleRuntimeException(RuntimeException ex) {
        ServiceResponse response = ServiceResponse.builder()
                .status("Failed")
                .statusCode("401")
                .message("Unauthorized")
                .build();

        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }
}
