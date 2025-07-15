package com.duolingo.clone.courseservice.mapper;

import com.duolingo.clone.courseservice.dto.LessonDto;
import com.duolingo.clone.courseservice.dto.LessonResponseDto;
import com.duolingo.clone.courseservice.entity.Lesson;

public class LessonMapper {
    public static Lesson toEntity(LessonDto dto) {
        return Lesson.builder()
                .lessonTitle(dto.getLessonTitle())
                .lessonOrder(dto.getLessonOrder())
                .build();
    }

    public static LessonResponseDto toLessonResponseDto(Lesson lesson) {
        return LessonResponseDto.builder()
                .lessonId(lesson.getLessonId())
                .lessonTitle(lesson.getLessonTitle())
                .lessonOrder(lesson.getLessonOrder())
                .unitId(lesson.getUnit().getUnitId())
                .build();
    }
}