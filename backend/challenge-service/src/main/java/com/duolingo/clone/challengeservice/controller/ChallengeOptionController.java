package com.duolingo.clone.challengeservice.controller;

import com.duolingo.clone.challengeservice.dto.request.ChallengeOptionRequestDTO;
import com.duolingo.clone.challengeservice.dto.response.ChallengeOptionResponseDTO;
import com.duolingo.clone.challengeservice.service.ChallengeOptionService;
import com.duolingo.clone.common.response.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/challenge-options")
@RequiredArgsConstructor
public class ChallengeOptionController {

    private final ChallengeOptionService challengeOptionService;

    @PostMapping
    public ResponseEntity<ApiResponse<ChallengeOptionResponseDTO>> createOption(
            @Valid @RequestBody ChallengeOptionRequestDTO dto,
            HttpServletRequest request) {

        ChallengeOptionResponseDTO result = challengeOptionService.createChallengeOption(dto);
        return ResponseEntity.ok(
                ApiResponse.ok(
                        "Challenge option created",
                        HttpStatus.OK.value(),
                        request.getRequestURI(),
                        UUID.randomUUID().toString(),
                        result
                )
        );
    }

    @GetMapping("/challenge/{challengeId}")
    public ResponseEntity<ApiResponse<List<ChallengeOptionResponseDTO>>> getOptionsByChallenge(
            @PathVariable Long challengeId,
            HttpServletRequest request) {

        List<ChallengeOptionResponseDTO> result = challengeOptionService.getOptionsByChallengeId(challengeId);
        return ResponseEntity.ok(
                ApiResponse.ok(
                        "Options fetched",
                        HttpStatus.OK.value(),
                        request.getRequestURI(),
                        UUID.randomUUID().toString(),
                        result
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteOption(
            @PathVariable Long id,
            HttpServletRequest request) {

        challengeOptionService.deleteChallengeOption(id);
        return ResponseEntity.ok(
                ApiResponse.ok(
                        "Challenge option deleted",
                        HttpStatus.OK.value(),
                        request.getRequestURI(),
                        UUID.randomUUID().toString(),
                        null
                )
        );
    }
}