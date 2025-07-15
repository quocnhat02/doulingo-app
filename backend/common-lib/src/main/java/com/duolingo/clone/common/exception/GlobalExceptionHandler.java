package com.duolingo.clone.common.exception;


import com.duolingo.clone.common.response.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.UUID;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<?>> handleValidationErrors(MethodArgumentNotValidException ex, HttpServletRequest request) {
        String errorMessage = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .findFirst()
                .orElse("Invalid input");

        return ResponseEntity
                .badRequest()
                .body(ApiResponse.error(errorMessage, 400, request.getRequestURI(), UUID.randomUUID().toString()));
    }

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiResponse<?>> handleApiException(ApiException ex, HttpServletRequest request) {
        String requestId = UUID.randomUUID().toString();
        return ResponseEntity
                .status(ex.getStatus())
                .body(ApiResponse.error(
                        ex.getMessage(),
                        ex.getStatus().value(),
                        request.getRequestURI(),
                        requestId
                ));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleOtherExceptions(Exception ex, HttpServletRequest request) {
        String requestId = UUID.randomUUID().toString();
        return ResponseEntity
                .internalServerError()
                .body(ApiResponse.error(
                        "Internal Server Error: " + ex.getMessage(),
                        500,
                        request.getRequestURI(),
                        requestId
                ));
    }
}