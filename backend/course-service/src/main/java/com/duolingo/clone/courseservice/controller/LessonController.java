package com.duolingo.clone.courseservice.controller;

import com.duolingo.clone.common.response.ApiResponse;
import com.duolingo.clone.courseservice.dto.LessonDto;
import com.duolingo.clone.courseservice.dto.LessonResponseDto;
import com.duolingo.clone.courseservice.service.LessonService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/lessons")
@RequiredArgsConstructor
public class LessonController {

    private final LessonService lessonService;

    @PostMapping
    public ResponseEntity<ApiResponse<LessonResponseDto>> createLesson(@Valid @RequestBody LessonDto dto, HttpServletRequest request) {
        LessonResponseDto result = lessonService.createLesson(dto);
        return ResponseEntity.ok(ApiResponse.ok("Lesson created successfully", HttpStatus.OK.value(), request.getRequestURI(), UUID.randomUUID().toString(), result));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<LessonResponseDto>>> getAllLessons(HttpServletRequest request) {
        List<LessonResponseDto> result = lessonService.getAllLessons();
        return ResponseEntity.ok(ApiResponse.ok("All lessons fetched", HttpStatus.OK.value(), request.getRequestURI(), UUID.randomUUID().toString(), result));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<LessonResponseDto>> getLessonById(@PathVariable Long id, HttpServletRequest request) {
        LessonResponseDto result = lessonService.getLessonById(id);
        return ResponseEntity.ok(ApiResponse.ok("Lesson fetched", HttpStatus.OK.value(), request.getRequestURI(), UUID.randomUUID().toString(), result));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<LessonResponseDto>> updateLesson(@PathVariable Long id, @Valid @RequestBody LessonDto dto, HttpServletRequest request) {
        LessonResponseDto result = lessonService.updateLesson(id, dto);
        return ResponseEntity.ok(ApiResponse.ok("Lesson updated", HttpStatus.OK.value(), request.getRequestURI(), UUID.randomUUID().toString(), result));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteLesson(@PathVariable Long id, HttpServletRequest request) {
        lessonService.deleteLesson(id);
        return ResponseEntity.ok(ApiResponse.ok("Lesson deleted", HttpStatus.OK.value(), request.getRequestURI(), UUID.randomUUID().toString(), null));
    }
}