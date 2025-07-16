package com.duolingo.clone.challengeservice.service;

import com.duolingo.clone.challengeservice.dto.ChallengeDto;
import com.duolingo.clone.challengeservice.dto.ChallengeResponseDto;

import java.util.List;

public interface ChallengeService {
    ChallengeResponseDto createChallenge(ChallengeDto dto);
    List<ChallengeResponseDto> getChallengesByLesson(Long lessonId);
    ChallengeResponseDto getChallenge(Long id);
    ChallengeResponseDto updateChallenge(Long id, ChallengeDto dto);
    void deleteChallenge(Long id);
}
