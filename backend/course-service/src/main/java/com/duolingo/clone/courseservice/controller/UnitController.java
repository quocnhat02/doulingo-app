package com.duolingo.clone.courseservice.controller;

import com.duolingo.clone.common.response.ApiResponse;
import com.duolingo.clone.courseservice.dto.UnitDto;
import com.duolingo.clone.courseservice.dto.UnitResponseDto;
import com.duolingo.clone.courseservice.entity.Unit;
import com.duolingo.clone.courseservice.service.UnitService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/units")
@RequiredArgsConstructor
public class UnitController {

    private final UnitService unitService;

    @PostMapping
    public ResponseEntity<ApiResponse<UnitResponseDto>> createUnit(@Valid @RequestBody UnitDto dto, HttpServletRequest request) {
        UnitResponseDto result = unitService.createUnit(dto);
        return ResponseEntity.ok(ApiResponse.ok("Unit created successfully", HttpStatus.OK.value(), request.getRequestURI(), UUID.randomUUID().toString(), result));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<UnitResponseDto>>> getAllUnits(HttpServletRequest request) {
        List<UnitResponseDto> result = unitService.getAllUnits();
        return ResponseEntity.ok(ApiResponse.ok("All units fetched", HttpStatus.OK.value(), request.getRequestURI(), UUID.randomUUID().toString(), result));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UnitResponseDto>> getUnitById(@PathVariable Long id, HttpServletRequest request) {
        UnitResponseDto result = unitService.getUnitById(id);
        return ResponseEntity.ok(ApiResponse.ok("Unit fetched", HttpStatus.OK.value(), request.getRequestURI(), UUID.randomUUID().toString(), result));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<UnitResponseDto>> updateUnit(@PathVariable Long id, @Valid @RequestBody UnitDto dto, HttpServletRequest request) {
        UnitResponseDto result = unitService.updateUnit(id, dto);
        return ResponseEntity.ok(ApiResponse.ok("Unit updated", HttpStatus.OK.value(), request.getRequestURI(), UUID.randomUUID().toString(), result));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteUnit(@PathVariable Long id, HttpServletRequest request) {
        unitService.deleteUnit(id);
        return ResponseEntity.ok(ApiResponse.ok("Unit deleted", HttpStatus.OK.value(), request.getRequestURI(), UUID.randomUUID().toString(), null));
    }
}