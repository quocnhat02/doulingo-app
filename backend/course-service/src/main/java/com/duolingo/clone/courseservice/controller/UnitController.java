package com.duolingo.clone.courseservice.controller;

import com.duolingo.clone.common.response.ApiResponse;
import com.duolingo.clone.courseservice.dto.request.UnitRequestDTO;
import com.duolingo.clone.courseservice.dto.response.UnitResponseDTO;
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
    public ResponseEntity<ApiResponse<UnitResponseDTO>> createUnit(
            @Valid @RequestBody UnitRequestDTO dto,
            HttpServletRequest request) {

        UnitResponseDTO result = unitService.createUnit(dto);
        return ResponseEntity.ok(
                ApiResponse.ok(
                        "Unit created successfully",
                        HttpStatus.OK.value(),
                        request.getRequestURI(),
                        UUID.randomUUID().toString(),
                        result
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UnitResponseDTO>> getUnitById(
            @PathVariable Long id,
            HttpServletRequest request) {

        UnitResponseDTO result = unitService.getUnitById(id);
        return ResponseEntity.ok(
                ApiResponse.ok(
                        "Unit fetched",
                        HttpStatus.OK.value(),
                        request.getRequestURI(),
                        UUID.randomUUID().toString(),
                        result
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteUnit(
            @PathVariable Long id,
            HttpServletRequest request) {

        unitService.deleteUnit(id);
        return ResponseEntity.ok(
                ApiResponse.ok(
                        "Unit deleted",
                        HttpStatus.OK.value(),
                        request.getRequestURI(),
                        UUID.randomUUID().toString(),
                        null
                )
        );
    }
}