package com.duolingo.clone.courseservice.service.impl;

import com.duolingo.clone.common.exception.ResourceNotFoundException;
import com.duolingo.clone.courseservice.dto.LessonDto;
import com.duolingo.clone.courseservice.dto.LessonResponseDto;
import com.duolingo.clone.courseservice.entity.Lesson;
import com.duolingo.clone.courseservice.entity.Unit;
import com.duolingo.clone.courseservice.mapper.LessonMapper;
import com.duolingo.clone.courseservice.repository.LessonRepository;
import com.duolingo.clone.courseservice.repository.UnitRepository;
import com.duolingo.clone.courseservice.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;
    private final UnitRepository unitRepository;

    @Override
    public LessonResponseDto createLesson(LessonDto dto) {
        Unit unit = unitRepository.findById(dto.getUnitId())
                .orElseThrow(() -> new ResourceNotFoundException("Unit not found with id: " + dto.getUnitId()));

        Lesson lesson = LessonMapper.toEntity(dto);
        lesson.setUnit(unit);

        Lesson saved = lessonRepository.save(lesson);
        return LessonMapper.toLessonResponseDto(saved);
    }

    @Override
    public List<LessonResponseDto> getAllLessons() {
        return lessonRepository.findAll().stream()
                .map(LessonMapper::toLessonResponseDto)
                .toList();
    }

    @Override
    public LessonResponseDto getLessonById(Long id) {
        Lesson lesson = lessonRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lesson not found with id: " + id));
        return LessonMapper.toLessonResponseDto(lesson);
    }

    @Override
    public LessonResponseDto updateLesson(Long id, LessonDto dto) {
        Lesson lesson = lessonRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lesson not found with id: " + id));

        Unit unit = unitRepository.findById(dto.getUnitId())
                .orElseThrow(() -> new ResourceNotFoundException("Unit not found with id: " + dto.getUnitId()));

        lesson.setLessonTitle(dto.getLessonTitle());
        lesson.setLessonOrder(dto.getLessonOrder());
        lesson.setUnit(unit);

        Lesson updated = lessonRepository.save(lesson);
        return LessonMapper.toLessonResponseDto(updated);
    }

    @Override
    public void deleteLesson(Long id) {
        if (!lessonRepository.existsById(id)) {
            throw new ResourceNotFoundException("Lesson not found with id: " + id);
        }
        lessonRepository.deleteById(id);
    }
}