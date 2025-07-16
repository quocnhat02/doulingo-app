package com.duolingo.clone.challengeservice.controller;

import com.duolingo.clone.challengeservice.dto.request.ChallengeRequestDTO;
import com.duolingo.clone.challengeservice.dto.response.ChallengeResponseDTO;
import com.duolingo.clone.challengeservice.service.ChallengeService;
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
@RequestMapping("/api/challenges")
@RequiredArgsConstructor
public class ChallengeController {

    private final ChallengeService challengeService;

    @PostMapping
    public ResponseEntity<ApiResponse<ChallengeResponseDTO>> createChallenge(
            @Valid @RequestBody ChallengeRequestDTO dto,
            HttpServletRequest request) {

        ChallengeResponseDTO created = challengeService.createChallenge(dto);
        return ResponseEntity.ok(
                ApiResponse.ok(
                        "Challenge created successfully",
                        HttpStatus.OK.value(),
                        request.getRequestURI(),
                        UUID.randomUUID().toString(),
                        created
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ChallengeResponseDTO>> getChallengeById(
            @PathVariable Long id,
            HttpServletRequest request) {

        ChallengeResponseDTO challenge = challengeService.getChallengeById(id);
        return ResponseEntity.ok(
                ApiResponse.ok(
                        "Challenge fetched successfully",
                        HttpStatus.OK.value(),
                        request.getRequestURI(),
                        UUID.randomUUID().toString(),
                        challenge
                )
        );
    }

    @GetMapping("/lesson/{lessonId}")
    public ResponseEntity<ApiResponse<List<ChallengeResponseDTO>>> getChallengesByLessonId(
            @PathVariable Long lessonId,
            HttpServletRequest request) {

        List<ChallengeResponseDTO> challenges = challengeService.getChallengesByLessonId(lessonId);
        return ResponseEntity.ok(
                ApiResponse.ok(
                        "Challenges by lesson fetched",
                        HttpStatus.OK.value(),
                        request.getRequestURI(),
                        UUID.randomUUID().toString(),
                        challenges
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteChallenge(
            @PathVariable Long id,
            HttpServletRequest request) {

        challengeService.deleteChallenge(id);
        return ResponseEntity.ok(
                ApiResponse.ok(
                        "Challenge deleted",
                        HttpStatus.OK.value(),
                        request.getRequestURI(),
                        UUID.randomUUID().toString(),
                        null
                )
        );
    }
}
