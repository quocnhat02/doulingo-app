package com.duolingo.clone.challengeservice.service.impl;

import com.duolingo.clone.challengeservice.dto.request.ChallengeOptionRequestDTO;
import com.duolingo.clone.challengeservice.dto.response.ChallengeOptionResponseDTO;
import com.duolingo.clone.challengeservice.entity.Challenge;
import com.duolingo.clone.challengeservice.entity.ChallengeOption;
import com.duolingo.clone.challengeservice.repository.ChallengeOptionRepository;
import com.duolingo.clone.challengeservice.repository.ChallengeRepository;
import com.duolingo.clone.challengeservice.service.ChallengeOptionService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChallengeOptionServiceImpl implements ChallengeOptionService {

    private final ChallengeOptionRepository challengeOptionRepository;
    private final ChallengeRepository challengeRepository;

    @Override
    @Transactional
    public ChallengeOptionResponseDTO createChallengeOption(ChallengeOptionRequestDTO dto) {
        Challenge challenge = challengeRepository.findById(dto.getChallengeId())
                .orElseThrow(() -> new IllegalArgumentException("Challenge not found"));

        ChallengeOption option = ChallengeOption.builder()
                .optionText(dto.getOptionText())
                .imageSrc(dto.getImageSrc())
                .audioSrc(dto.getAudioSrc())
                .isCorrect(dto.isCorrect())
                .challenge(challenge)
                .build();

        ChallengeOption saved = challengeOptionRepository.save(option);
        return mapToDTO(saved);
    }

    @Override
    public List<ChallengeOptionResponseDTO> getOptionsByChallengeId(Long challengeId) {
        return challengeOptionRepository.findByChallenge_ChallengeId(challengeId)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteChallengeOption(Long id) {
        challengeOptionRepository.deleteById(id);
    }

    private ChallengeOptionResponseDTO mapToDTO(ChallengeOption option) {
        ChallengeOptionResponseDTO dto = new ChallengeOptionResponseDTO();
        dto.setChallengeOptionId(option.getChallengeOptionId());
        dto.setOptionText(option.getOptionText());
        dto.setImageSrc(option.getImageSrc());
        dto.setAudioSrc(option.getAudioSrc());
        dto.setCorrect(option.isCorrect());
        dto.setChallengeId(option.getChallenge().getChallengeId());
        return dto;
    }
}