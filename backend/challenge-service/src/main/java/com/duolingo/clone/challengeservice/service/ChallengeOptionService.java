package com.duolingo.clone.challengeservice.service;

import com.duolingo.clone.challengeservice.dto.request.ChallengeOptionRequestDTO;
import com.duolingo.clone.challengeservice.dto.response.ChallengeOptionResponseDTO;

import java.util.List;

public interface ChallengeOptionService {
    ChallengeOptionResponseDTO createChallengeOption(ChallengeOptionRequestDTO dto);
    List<ChallengeOptionResponseDTO> getOptionsByChallengeId(Long challengeId);
    void deleteChallengeOption(Long id);
}