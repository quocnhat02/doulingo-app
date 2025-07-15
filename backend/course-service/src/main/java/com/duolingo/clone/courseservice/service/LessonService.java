package com.duolingo.clone.courseservice.service;

import com.duolingo.clone.courseservice.dto.LessonDto;
import com.duolingo.clone.courseservice.dto.LessonResponseDto;
import com.duolingo.clone.courseservice.entity.Lesson;

import java.util.List;

public interface LessonService {
    LessonResponseDto createLesson(LessonDto dto);
    LessonResponseDto getLessonById(Long id);
    List<LessonResponseDto> getAllLessons();
    LessonResponseDto updateLesson(Long id, LessonDto dto);
    void deleteLesson(Long id);
}
