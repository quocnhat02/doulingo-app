package com.duolingo.clone.courseservice.service;

import com.duolingo.clone.courseservice.dto.CourseDto;
import com.duolingo.clone.courseservice.dto.CourseResponseDto;
import com.duolingo.clone.courseservice.entity.Course;

import java.util.List;

public interface CourseService {
    CourseResponseDto createCourse(CourseDto dto);
    CourseResponseDto getCourseById(Long id);
    List<CourseResponseDto> getAllCourses();
    CourseResponseDto updateCourse(Long id, CourseDto dto);
    void deleteCourse(Long id);
}
