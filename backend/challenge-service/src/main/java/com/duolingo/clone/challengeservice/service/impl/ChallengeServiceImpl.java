package com.duolingo.clone.challengeservice.service.impl;

import com.duolingo.clone.challengeservice.client.LessonClient;
import com.duolingo.clone.challengeservice.dto.request.ChallengeRequestDTO;
import com.duolingo.clone.challengeservice.dto.response.ChallengeResponseDTO;
import com.duolingo.clone.challengeservice.entity.Challenge;
import com.duolingo.clone.challengeservice.repository.ChallengeRepository;
import com.duolingo.clone.challengeservice.service.ChallengeService;
import com.duolingo.clone.common.dto.LessonResponseDTO;
import com.duolingo.clone.common.exception.BadRequestException;
import com.duolingo.clone.common.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChallengeServiceImpl implements ChallengeService {

    private final ChallengeRepository challengeRepository;
    private final LessonClient lessonClient;

    @Retryable(
            value = { ResourceAccessException.class },
            maxAttempts = 3,
            backoff = @Backoff(delay = 3000))
    public LessonResponseDTO safeGetLessonById(Long lessonId) {
        return lessonClient.getLessonById(lessonId).getData();
    }

    @Recover
    public LessonResponseDTO recoverLesson(ResourceAccessException ex, Long lessonId) {
//        log.error("Retry failed for lessonId {}: {}", lessonId, ex.getMessage());
        throw new BadRequestException("Cannot verify lesson from course-service");
    }


    @Override
    public ChallengeResponseDTO createChallenge(ChallengeRequestDTO dto) {
        // Gọi course-service kiểm tra lessonId có tồn tại không
        LessonResponseDTO lesson = safeGetLessonById(dto.getLessonId());
        if (lesson == null) {
            throw new ResourceNotFoundException("Lesson not found");
        }

        Challenge challenge = Challenge.builder()
                .challengeQuestion(dto.getChallengeQuestion())
                .challengeType(dto.getChallengeType())
                .lessonId(dto.getLessonId())
                .challengeOrder(dto.getChallengeOrder())
                .build();

        Challenge saved = challengeRepository.save(challenge);
        return mapToDTO(saved);
    }

    @Override
    public ChallengeResponseDTO getChallengeById(Long id) {
        Challenge challenge = challengeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Challenge not found"));
        return mapToDTO(challenge);
    }

    @Override
    public List<ChallengeResponseDTO> getChallengesByLessonId(Long lessonId) {
        return challengeRepository.findByLessonId(lessonId)
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    @Override
    public void deleteChallenge(Long id) {
        if (!challengeRepository.existsById(id)) {
            throw new ResourceNotFoundException("Challenge not found");
        }
        challengeRepository.deleteById(id);
    }

    private ChallengeResponseDTO mapToDTO(Challenge challenge) {
        ChallengeResponseDTO dto = new ChallengeResponseDTO();
        dto.setChallengeId(challenge.getChallengeId());
        dto.setChallengeQuestion(challenge.getChallengeQuestion());
        dto.setChallengeType(challenge.getChallengeType());
        dto.setChallengeOrder(challenge.getChallengeOrder());
        dto.setLessonId(challenge.getLessonId());
        return dto;
    }
}