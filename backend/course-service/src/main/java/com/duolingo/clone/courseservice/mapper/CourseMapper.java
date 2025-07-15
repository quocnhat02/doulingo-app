package com.duolingo.clone.courseservice.mapper;

import com.duolingo.clone.courseservice.dto.CourseDto;
import com.duolingo.clone.courseservice.dto.CourseResponseDto;
import com.duolingo.clone.courseservice.entity.Course;

public class CourseMapper {
    public static Course toEntity(CourseDto dto) {
        return Course.builder()
                .courseTitle(dto.getCourseTitle())
                .courseImageSrc(dto.getCourseImageSrc())
                .build();
    }

    public static CourseResponseDto toResponseDto(Course course) {
        return CourseResponseDto.builder()
                .courseId(course.getCourseId())
                .courseTitle(course.getCourseTitle())
                .courseImageSrc(course.getCourseImageSrc())
                .build();
    }
}