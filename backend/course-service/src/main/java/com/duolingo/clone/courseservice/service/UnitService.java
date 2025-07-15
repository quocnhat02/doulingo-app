package com.duolingo.clone.courseservice.service;

import com.duolingo.clone.courseservice.dto.UnitDto;
import com.duolingo.clone.courseservice.dto.UnitResponseDto;
import com.duolingo.clone.courseservice.entity.Unit;

import java.util.List;

public interface UnitService {
    UnitResponseDto createUnit(UnitDto dto);
    UnitResponseDto getUnitById(Long id);
    List<UnitResponseDto> getAllUnits();
    UnitResponseDto updateUnit(Long id, UnitDto dto);
    void deleteUnit(Long id);
}
