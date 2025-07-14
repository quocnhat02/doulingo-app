package com.duolingo.clone.common.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String resourceName, Object id) {
        super(resourceName + " with ID " + id + " not found");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}