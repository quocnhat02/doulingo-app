package com.duolingo.clone.common.exception;

import org.springframework.http.HttpStatus;

public class ValidationException extends ApiException {
    public ValidationException(String message) {
        super(message, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}