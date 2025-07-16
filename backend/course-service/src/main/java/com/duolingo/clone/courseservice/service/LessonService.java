package com.duolingo.clone.courseservice.service;

import com.duolingo.clone.courseservice.dto.request.LessonRequestDTO;
import com.duolingo.clone.courseservice.dto.response.LessonResponseDTO;

import java.util.List;

public interface LessonService {
    LessonResponseDTO createLesson(LessonRequestDTO dto);
    LessonResponseDTO getLessonById(Long id);
    void deleteLesson(Long id);
}
