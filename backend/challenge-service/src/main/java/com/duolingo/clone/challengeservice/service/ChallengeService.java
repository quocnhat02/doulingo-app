package com.duolingo.clone.challengeservice.service;

import com.duolingo.clone.challengeservice.dto.request.ChallengeRequestDTO;
import com.duolingo.clone.challengeservice.dto.response.ChallengeResponseDTO;

import java.util.List;

public interface ChallengeService {
    ChallengeResponseDTO createChallenge(ChallengeRequestDTO dto);
    ChallengeResponseDTO getChallengeById(Long id);
    List<ChallengeResponseDTO> getChallengesByLessonId(Long lessonId);
    void deleteChallenge(Long id);
}
