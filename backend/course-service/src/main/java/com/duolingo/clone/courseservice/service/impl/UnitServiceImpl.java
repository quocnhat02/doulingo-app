package com.duolingo.clone.courseservice.service.impl;

import com.duolingo.clone.common.exception.ResourceNotFoundException;
import com.duolingo.clone.courseservice.dto.request.UnitRequestDTO;
import com.duolingo.clone.courseservice.dto.response.UnitResponseDTO;
import com.duolingo.clone.courseservice.entity.Course;
import com.duolingo.clone.courseservice.entity.Unit;
import com.duolingo.clone.courseservice.repository.CourseRepository;
import com.duolingo.clone.courseservice.repository.UnitRepository;
import com.duolingo.clone.courseservice.service.UnitService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UnitServiceImpl implements UnitService {

    private final UnitRepository unitRepository;
    private final CourseRepository courseRepository;

    @Override
    @Transactional
    public UnitResponseDTO createUnit(UnitRequestDTO dto) {
        Course course = courseRepository.findById(dto.getCourseId())
                .orElseThrow(() -> new ResourceNotFoundException("Course not found"));

        Unit unit = Unit.builder()
                .unitTitle(dto.getUnitTitle())
                .unitDescription(dto.getUnitDescription())
                .unitOrder(dto.getUnitOrder())
                .course(course)
                .build();

        unit = unitRepository.save(unit);

        UnitResponseDTO response = new UnitResponseDTO();
        response.setUnitId(unit.getUnitId());
        response.setUnitTitle(unit.getUnitTitle());
        response.setUnitDescription(unit.getUnitDescription());
        response.setUnitOrder(unit.getUnitOrder());
        response.setCourseId(course.getCourseId());

        return response;
    }

    @Override
    public UnitResponseDTO getUnitById(Long id) {
        Unit unit = unitRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Unit not found"));

        UnitResponseDTO response = new UnitResponseDTO();
        response.setUnitId(unit.getUnitId());
        response.setUnitTitle(unit.getUnitTitle());
        response.setUnitDescription(unit.getUnitDescription());
        response.setUnitOrder(unit.getUnitOrder());
        response.setCourseId(unit.getCourse().getCourseId());

        return response;
    }

    @Override
    public void deleteUnit(Long id) {
        unitRepository.deleteById(id);
    }
}