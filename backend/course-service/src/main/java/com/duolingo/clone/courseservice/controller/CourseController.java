package com.duolingo.clone.courseservice.controller;

import com.duolingo.clone.common.response.ApiResponse;
import com.duolingo.clone.courseservice.dto.CourseDto;
import com.duolingo.clone.courseservice.dto.CourseResponseDto;
import com.duolingo.clone.courseservice.entity.Course;
import com.duolingo.clone.courseservice.service.CourseService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public ResponseEntity<ApiResponse<CourseResponseDto>> createCourse(
            @RequestBody CourseDto dto,
            HttpServletRequest request) {

        CourseResponseDto result = courseService.createCourse(dto);
        return ResponseEntity.ok(
                ApiResponse.ok(
                        "Course created successfully",
                        HttpStatus.OK.value(),
                        request.getRequestURI(),
                        UUID.randomUUID().toString(),
                        result
                )
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<CourseResponseDto>>> getAllCourses(
            HttpServletRequest request) {

        List<CourseResponseDto> result = courseService.getAllCourses();
        return ResponseEntity.ok(
                ApiResponse.ok(
                        "All courses fetched",
                        HttpStatus.OK.value(),
                        request.getRequestURI(),
                        UUID.randomUUID().toString(),
                        result
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CourseResponseDto>> getCourse(
            @PathVariable Long id,
            HttpServletRequest request) {

        CourseResponseDto result = courseService.getCourseById(id);
        return ResponseEntity.ok(
                ApiResponse.ok(
                        "Course fetched",
                        HttpStatus.OK.value(),
                        request.getRequestURI(),
                        UUID.randomUUID().toString(),
                        result
                )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<CourseResponseDto>> updateCourse(
            @PathVariable Long id,
            @RequestBody CourseDto dto,
            HttpServletRequest request) {

        CourseResponseDto result = courseService.updateCourse(id, dto);
        return ResponseEntity.ok(
                ApiResponse.ok(
                        "Course updated",
                        HttpStatus.OK.value(),
                        request.getRequestURI(),
                        UUID.randomUUID().toString(),
                        result
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteCourse(
            @PathVariable Long id,
            HttpServletRequest request) {

        courseService.deleteCourse(id);
        return ResponseEntity.ok(
                ApiResponse.ok(
                        "Course deleted",
                        HttpStatus.OK.value(),
                        request.getRequestURI(),
                        UUID.randomUUID().toString(),
                        null
                )
        );
    }
}