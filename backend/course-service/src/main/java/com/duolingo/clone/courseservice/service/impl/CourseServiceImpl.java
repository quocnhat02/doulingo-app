package com.duolingo.clone.courseservice.service.impl;

import com.duolingo.clone.common.exception.ResourceNotFoundException;
import com.duolingo.clone.courseservice.dto.request.CourseRequestDTO;
import com.duolingo.clone.courseservice.dto.response.CourseResponseDTO;
import com.duolingo.clone.courseservice.entity.Course;
import com.duolingo.clone.courseservice.repository.CourseRepository;
import com.duolingo.clone.courseservice.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public List<CourseResponseDTO> searchByTitle(String title) {
        return courseRepository.findByCourseTitleContainingIgnoreCase(title)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CourseResponseDTO> getCoursesWithPagination(int page, int size) {
        return courseRepository.findAll(PageRequest.of(page, size))
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CourseResponseDTO createCourse(CourseRequestDTO dto) {
        Course course = Course.builder()
                .courseTitle(dto.getCourseTitle())
                .courseImageSrc(dto.getCourseImageSrc())
                .build();
        Course saved = courseRepository.save(course);
        return mapToDTO(saved);
    }

    @Override
    public List<CourseResponseDTO> getAllCourses() {
        return courseRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CourseResponseDTO getCourseById(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found"));
        return mapToDTO(course);
    }

    @Override
    public CourseResponseDTO updateCourse(Long id, CourseRequestDTO dto) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found"));
        course.setCourseTitle(dto.getCourseTitle());
        course.setCourseImageSrc(dto.getCourseImageSrc());
        Course updated = courseRepository.save(course);
        return mapToDTO(updated);
    }

    @Override
    public void deleteCourse(Long id) {
        if (!courseRepository.existsById(id)) {
            throw new ResourceNotFoundException("Course not found");
        }
        courseRepository.deleteById(id);
    }

    private CourseResponseDTO mapToDTO(Course course) {
        CourseResponseDTO dto = new CourseResponseDTO();
        dto.setCourseId(course.getCourseId());
        dto.setCourseTitle(course.getCourseTitle());
        dto.setCourseImageSrc(course.getCourseImageSrc());
        return dto;
    }
}
