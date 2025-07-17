package com.duolingo.clone.courseservice.service.impl;

import com.duolingo.clone.common.dto.LessonResponseDTO;
import com.duolingo.clone.common.exception.ResourceNotFoundException;
import com.duolingo.clone.courseservice.dto.request.LessonRequestDTO;
import com.duolingo.clone.courseservice.entity.Lesson;
import com.duolingo.clone.courseservice.entity.Unit;
import com.duolingo.clone.courseservice.repository.LessonRepository;
import com.duolingo.clone.courseservice.repository.UnitRepository;
import com.duolingo.clone.courseservice.service.LessonService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;
    private final UnitRepository unitRepository;

    @Override
    @Transactional
    public LessonResponseDTO createLesson(LessonRequestDTO dto) {
        Unit unit = unitRepository.findById(dto.getUnitId())
                .orElseThrow(() -> new ResourceNotFoundException("Unit not found"));

        Lesson lesson = Lesson.builder()
                .lessonTitle(dto.getLessonTitle())
                .lessonOrder(dto.getLessonOrder())
                .unit(unit)
                .build();

        lesson = lessonRepository.save(lesson);

        LessonResponseDTO response = new LessonResponseDTO();
        response.setLessonId(lesson.getLessonId());
        response.setLessonTitle(lesson.getLessonTitle());
        response.setLessonOrder(lesson.getLessonOrder());
        response.setUnitId(unit.getUnitId());

        return response;
    }

    @Override
    public LessonResponseDTO getLessonById(Long id) {
        Lesson lesson = lessonRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lesson not found"));

        LessonResponseDTO response = new LessonResponseDTO();
        response.setLessonId(lesson.getLessonId());
        response.setLessonTitle(lesson.getLessonTitle());
        response.setLessonOrder(lesson.getLessonOrder());
        response.setUnitId(lesson.getUnit().getUnitId());

        return response;
    }

    @Override
    public void deleteLesson(Long id) {
        lessonRepository.deleteById(id);
    }
}