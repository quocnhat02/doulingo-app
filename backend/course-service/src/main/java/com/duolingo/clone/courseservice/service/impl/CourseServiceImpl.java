package com.duolingo.clone.courseservice.service.impl;

import com.duolingo.clone.common.exception.ResourceNotFoundException;
import com.duolingo.clone.courseservice.dto.CourseDto;
import com.duolingo.clone.courseservice.dto.CourseResponseDto;
import com.duolingo.clone.courseservice.entity.Course;
import com.duolingo.clone.courseservice.mapper.CourseMapper;
import com.duolingo.clone.courseservice.repository.CourseRepository;
import com.duolingo.clone.courseservice.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public CourseResponseDto createCourse(CourseDto dto) {
        Course saved = courseRepository.save(CourseMapper.toEntity(dto));
        return CourseMapper.toResponseDto(saved);
    }

    @Override
    public List<CourseResponseDto> getAllCourses() {
        return courseRepository.findAll().stream()
                .map(CourseMapper::toResponseDto)
                .toList();
    }

    @Override
    public CourseResponseDto getCourseById(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id: " + id));
        return CourseMapper.toResponseDto(course);
    }

    @Override
    public CourseResponseDto updateCourse(Long id, CourseDto dto) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id: " + id));

        course.setCourseTitle(dto.getCourseTitle());
        course.setCourseImageSrc(dto.getCourseImageSrc());

        return CourseMapper.toResponseDto(courseRepository.save(course));
    }

    @Override
    public void deleteCourse(Long id) {
        if (!courseRepository.existsById(id)) {
            throw new ResourceNotFoundException("Course not found with id: " + id);
        }
        courseRepository.deleteById(id);
    }
}
