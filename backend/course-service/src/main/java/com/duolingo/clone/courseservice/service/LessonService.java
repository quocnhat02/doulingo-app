package com.duolingo.clone.courseservice.service;

import com.duolingo.clone.common.dto.LessonResponseDTO;
import com.duolingo.clone.courseservice.dto.request.LessonRequestDTO;

public interface LessonService {
    LessonResponseDTO createLesson(LessonRequestDTO dto);
    LessonResponseDTO getLessonById(Long id);
    void deleteLesson(Long id);
}
