package com.duolingo.clone.courseservice.controller;

import com.duolingo.clone.common.response.ApiResponse;
import com.duolingo.clone.courseservice.dto.request.CourseRequestDTO;
import com.duolingo.clone.courseservice.dto.response.CourseResponseDTO;
import com.duolingo.clone.courseservice.service.CourseService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
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

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<List<CourseResponseDTO>>> searchCoursesByTitle(
            @RequestParam String title,
            HttpServletRequest request) {

        List<CourseResponseDTO> result = courseService.searchByTitle(title);
        return ResponseEntity.ok(
                ApiResponse.ok(
                        "Search results fetched",
                        HttpStatus.OK.value(),
                        request.getRequestURI(),
                        UUID.randomUUID().toString(),
                        result
                )
        );
    }

    @GetMapping("/pagination")
    public ResponseEntity<ApiResponse<List<CourseResponseDTO>>> getCoursesWithPagination(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            HttpServletRequest request) {

        List<CourseResponseDTO> result = courseService.getCoursesWithPagination(page, size);
        return ResponseEntity.ok(
                ApiResponse.ok(
                        "Courses fetched with pagination",
                        HttpStatus.OK.value(),
                        request.getRequestURI(),
                        UUID.randomUUID().toString(),
                        result
                )
        );
    }

    @PostMapping
    public ResponseEntity<ApiResponse<CourseResponseDTO>> createCourse(
            @Valid @RequestBody CourseRequestDTO dto,
            HttpServletRequest request) {

        CourseResponseDTO result = courseService.createCourse(dto);
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
    public ResponseEntity<ApiResponse<List<CourseResponseDTO>>> getAllCourses(
            HttpServletRequest request) {

        List<CourseResponseDTO> result = courseService.getAllCourses();
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
    public ResponseEntity<ApiResponse<CourseResponseDTO>> getCourse(
            @PathVariable Long id,
            HttpServletRequest request) {

        CourseResponseDTO result = courseService.getCourseById(id);
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
    public ResponseEntity<ApiResponse<CourseResponseDTO>> updateCourse(
            @PathVariable Long id,
            @Valid @RequestBody CourseRequestDTO dto,
            HttpServletRequest request) {

        CourseResponseDTO result = courseService.updateCourse(id, dto);
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