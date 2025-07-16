package com.duolingo.clone.courseservice.service;

import com.duolingo.clone.courseservice.dto.request.CourseRequestDTO;
import com.duolingo.clone.courseservice.dto.response.CourseResponseDTO;

import java.util.List;

public interface CourseService {
    List<CourseResponseDTO> searchByTitle(String title);
    List<CourseResponseDTO> getCoursesWithPagination(int page, int size);
    List<CourseResponseDTO> getAllCourses();
    CourseResponseDTO getCourseById(Long id);
    CourseResponseDTO createCourse(CourseRequestDTO dto);
    CourseResponseDTO updateCourse(Long id, CourseRequestDTO dto);
    void deleteCourse(Long id);
}
