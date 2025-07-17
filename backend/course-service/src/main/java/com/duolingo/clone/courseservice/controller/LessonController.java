package com.duolingo.clone.courseservice.controller;

import com.duolingo.clone.common.dto.LessonResponseDTO;
import com.duolingo.clone.common.response.ApiResponse;
import com.duolingo.clone.courseservice.dto.request.LessonRequestDTO;
import com.duolingo.clone.courseservice.service.LessonService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/lessons")
@RequiredArgsConstructor
public class LessonController {

    private final LessonService lessonService;

    @PostMapping
    public ResponseEntity<ApiResponse<LessonResponseDTO>> createLesson(
            @Valid @RequestBody LessonRequestDTO dto,
            HttpServletRequest request) {

        LessonResponseDTO result = lessonService.createLesson(dto);
        return ResponseEntity.ok(
                ApiResponse.ok(
                        "Lesson created successfully",
                        HttpStatus.OK.value(),
                        request.getRequestURI(),
                        UUID.randomUUID().toString(),
                        result
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<LessonResponseDTO>> getLessonById(
            @PathVariable Long id,
            HttpServletRequest request) {

        LessonResponseDTO result = lessonService.getLessonById(id);
        return ResponseEntity.ok(
                ApiResponse.ok(
                        "Lesson fetched",
                        HttpStatus.OK.value(),
                        request.getRequestURI(),
                        UUID.randomUUID().toString(),
                        result
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteLesson(
            @PathVariable Long id,
            HttpServletRequest request) {

        lessonService.deleteLesson(id);
        return ResponseEntity.ok(
                ApiResponse.ok(
                        "Lesson deleted",
                        HttpStatus.OK.value(),
                        request.getRequestURI(),
                        UUID.randomUUID().toString(),
                        null
                )
        );
    }
}