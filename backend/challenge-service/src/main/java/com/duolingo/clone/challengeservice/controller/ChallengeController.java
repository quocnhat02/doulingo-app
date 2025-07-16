package com.duolingo.clone.challengeservice.controller;

import com.duolingo.clone.challengeservice.dto.ChallengeDto;
import com.duolingo.clone.challengeservice.dto.ChallengeResponseDto;
import com.duolingo.clone.challengeservice.service.ChallengeService;
import com.duolingo.clone.common.response.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
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

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<ChallengeResponseDto>> create(@RequestBody ChallengeDto dto, HttpServletRequest request) {
        ChallengeResponseDto result = challengeService.createChallenge(dto);
        return ResponseEntity.ok(ApiResponse.ok("Challenge created", HttpStatus.OK.value(), request.getRequestURI(), UUID.randomUUID().toString(), result));
    }

    @GetMapping("/lesson/{lessonId}")
    public ResponseEntity<ApiResponse<List<ChallengeResponseDto>>> getByLesson(@PathVariable Long lessonId, HttpServletRequest request) {
        List<ChallengeResponseDto> result = challengeService.getChallengesByLesson(lessonId);
        return ResponseEntity.ok(ApiResponse.ok("Fetched challenges", HttpStatus.OK.value(), request.getRequestURI(), UUID.randomUUID().toString(), result));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ChallengeResponseDto>> get(@PathVariable Long id, HttpServletRequest request) {
        ChallengeResponseDto result = challengeService.getChallenge(id);
        return ResponseEntity.ok(ApiResponse.ok("Challenge fetched", HttpStatus.OK.value(), request.getRequestURI(), UUID.randomUUID().toString(), result));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ChallengeResponseDto>> update(@PathVariable Long id, @RequestBody ChallengeDto dto, HttpServletRequest request) {
        ChallengeResponseDto result = challengeService.updateChallenge(id, dto);
        return ResponseEntity.ok(ApiResponse.ok("Challenge updated", HttpStatus.OK.value(), request.getRequestURI(), UUID.randomUUID().toString(), result));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id, HttpServletRequest request) {
        challengeService.deleteChallenge(id);
        return ResponseEntity.ok(ApiResponse.ok("Challenge deleted", HttpStatus.OK.value(), request.getRequestURI(), UUID.randomUUID().toString(), null));
    }
}
