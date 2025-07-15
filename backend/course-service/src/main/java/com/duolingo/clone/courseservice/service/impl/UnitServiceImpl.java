package com.duolingo.clone.courseservice.service.impl;

import com.duolingo.clone.common.exception.ResourceNotFoundException;
import com.duolingo.clone.courseservice.dto.UnitDto;
import com.duolingo.clone.courseservice.dto.UnitResponseDto;
import com.duolingo.clone.courseservice.entity.Course;
import com.duolingo.clone.courseservice.entity.Unit;
import com.duolingo.clone.courseservice.mapper.UnitMapper;
import com.duolingo.clone.courseservice.repository.CourseRepository;
import com.duolingo.clone.courseservice.repository.UnitRepository;
import com.duolingo.clone.courseservice.service.UnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UnitServiceImpl implements UnitService {

    private final UnitRepository unitRepository;
    private final CourseRepository courseRepository;

    @Override
    public UnitResponseDto createUnit(UnitDto dto) {
        Course course = courseRepository.findById(dto.getCourseId())
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id: " + dto.getCourseId()));

        Unit unit = UnitMapper.toEntity(dto);
        unit.setCourse(course);

        Unit saved = unitRepository.save(unit);
        return UnitMapper.toUnitResponseDto(saved); // ✅ Sửa chỗ này
    }

    @Override
    public List<UnitResponseDto> getAllUnits() {
        return unitRepository.findAll().stream()
                .map(UnitMapper::toUnitResponseDto)
                .toList();
    }

    @Override
    public UnitResponseDto getUnitById(Long id) {
        Unit unit = unitRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Unit not found with id: " + id));
        return UnitMapper.toUnitResponseDto(unit);
    }

    @Override
    public UnitResponseDto updateUnit(Long id, UnitDto dto) {
        Unit unit = unitRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Unit not found with id: " + id));

        Course course = courseRepository.findById(dto.getCourseId())
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id: " + dto.getCourseId()));

        unit.setUnitTitle(dto.getUnitTitle());
        unit.setUnitDescription(dto.getUnitDescription());
        unit.setUnitOrder(dto.getUnitOrder());
        unit.setCourse(course);

        return UnitMapper.toUnitResponseDto(unitRepository.save(unit));
    }

    @Override
    public void deleteUnit(Long id) {
        if (!unitRepository.existsById(id)) {
            throw new ResourceNotFoundException("Unit not found with id: " + id);
        }
        unitRepository.deleteById(id);
    }
}