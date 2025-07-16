package com.duolingo.clone.courseservice.service;

import com.duolingo.clone.courseservice.dto.request.UnitRequestDTO;
import com.duolingo.clone.courseservice.dto.response.UnitResponseDTO;

import java.util.List;

public interface UnitService {
    UnitResponseDTO createUnit(UnitRequestDTO dto);
    UnitResponseDTO getUnitById(Long id);
    void deleteUnit(Long id);
}
