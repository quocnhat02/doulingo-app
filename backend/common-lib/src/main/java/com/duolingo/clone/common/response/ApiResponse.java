package com.duolingo.clone.common.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
public class ApiResponse<T> {
    private boolean success;
    private String message;
    private int statusCode;
    private LocalDateTime timestamp;
    private String path;
    private String requestId;
    private T data;

    public static <T> ApiResponse<T> ok(String message, int statusCode, String path, String requestId, T data) {
        return ApiResponse.<T>builder()
                .success(true)
                .message(message)
                .statusCode(statusCode)
                .timestamp(LocalDateTime.now())
                .path(path)
                .requestId(requestId)
                .data(data)
                .build();
    }

    public static ApiResponse<?> error(String message, int statusCode, String path, String requestId) {
        return ApiResponse.builder()
                .success(false)
                .message(message)
                .statusCode(statusCode)
                .timestamp(LocalDateTime.now())
                .path(path)
                .requestId(requestId)
                .data(null)
                .build();
    }
}