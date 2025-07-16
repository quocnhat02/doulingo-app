package com.duolingo.clone.challengeservice.service.impl;

import com.duolingo.clone.challengeservice.client.LessonClient;
import com.duolingo.clone.challengeservice.entity.Challenge;
import com.duolingo.clone.challengeservice.mapper.ChallengeMapper;
import com.duolingo.clone.challengeservice.repository.ChallengeRepository;
import com.duolingo.clone.challengeservice.service.ChallengeService;
import com.duolingo.clone.common.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChallengeServiceImpl implements ChallengeService {

    private final ChallengeRepository challengeRepository;
    private final LessonClient lessonClient;

    @Override
    public ChallengeResponseDto createChallenge(ChallengeDto dto) {
        // Validate lessonId before saving challenge
        lessonClient.getLessonById(dto.getLessonId());

        Challenge saved = challengeRepository.save(ChallengeMapper.toEntity(dto));
        return ChallengeMapper.toResponseDto(saved);
    }

    @Override
    public List<ChallengeResponseDto> getChallengesByLesson(Long lessonId) {
        return challengeRepository.findByLessonId(lessonId)
                .stream().map(ChallengeMapper::toResponseDto).toList();
    }

    @Override
    public ChallengeResponseDto getChallenge(Long id) {
        Challenge challenge = challengeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Challenge not found with id: " + id));
        return ChallengeMapper.toResponseDto(challenge);
    }

    @Override
    public ChallengeResponseDto updateChallenge(Long id, ChallengeDto dto) {
        Challenge challenge = challengeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Challenge not found with id: " + id));

        challenge.setLessonId(dto.getLessonId());
        challenge.setType(dto.getType());
        challenge.setQuestion(dto.getQuestion());
        challenge.setChallengeOrder(dto.getChallengeOrder());

        return ChallengeMapper.toResponseDto(challengeRepository.save(challenge));
    }

    @Override
    public void deleteChallenge(Long id) {
        if (!challengeRepository.existsById(id)) {
            throw new ResourceNotFoundException("Challenge not found with id: " + id);
        }
        challengeRepository.deleteById(id);
    }
}