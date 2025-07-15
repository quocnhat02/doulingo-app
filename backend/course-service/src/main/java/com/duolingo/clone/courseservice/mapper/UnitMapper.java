package com.duolingo.clone.courseservice.mapper;

import com.duolingo.clone.courseservice.dto.UnitDto;
import com.duolingo.clone.courseservice.dto.UnitResponseDto;
import com.duolingo.clone.courseservice.entity.Unit;

public class UnitMapper {
    public static Unit toEntity(UnitDto dto) {
        return Unit.builder()
                .unitTitle(dto.getUnitTitle())
                .unitDescription(dto.getUnitDescription())
                .unitOrder(dto.getUnitOrder())
                .build();
    }

    public static UnitResponseDto toUnitResponseDto(Unit unit) {
        return UnitResponseDto.builder()
                .unitId(unit.getUnitId())
                .unitTitle(unit.getUnitTitle())
                .unitDescription(unit.getUnitDescription())
                .unitOrder(unit.getUnitOrder())
                .courseId(unit.getCourse().getCourseId())
                .build();
    }
}