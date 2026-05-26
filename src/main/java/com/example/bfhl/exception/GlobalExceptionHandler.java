package com.example.bfhl.exception;

import com.example.bfhl.dto.BfhlResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final String USER_ID = "vishal_saini_26052002";
    private static final String EMAIL = "vishal.saini.roll@xyz.com";
    private static final String ROLL_NUMBER = "VS12345";

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BfhlResponseDTO> handleAllExceptions(Exception ex) {
        BfhlResponseDTO errorResponse = new BfhlResponseDTO(
                false,
                USER_ID,
                EMAIL,
                ROLL_NUMBER,
                List.of(),
                List.of(),
                List.of(),
                List.of(),
                "0",
                ""
        );
        return ResponseEntity.badRequest().body(errorResponse);
    }
}
