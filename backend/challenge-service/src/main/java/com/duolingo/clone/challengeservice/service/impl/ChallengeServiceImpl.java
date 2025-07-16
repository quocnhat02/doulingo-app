package com.duolingo.clone.challengeservice.service.impl;

import com.duolingo.clone.challengeservice.client.LessonClient;
import com.duolingo.clone.challengeservice.dto.request.ChallengeRequestDTO;
import com.duolingo.clone.challengeservice.dto.response.ChallengeResponseDTO;
import com.duolingo.clone.challengeservice.entity.Challenge;
import com.duolingo.clone.challengeservice.repository.ChallengeRepository;
import com.duolingo.clone.challengeservice.service.ChallengeService;
import com.duolingo.clone.common.dto.LessonResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChallengeServiceImpl implements ChallengeService {

    private final ChallengeRepository challengeRepository;
    private final LessonClient lessonClient;

    @Override
    public ChallengeResponseDTO createChallenge(ChallengeRequestDTO dto) {
        // Gọi course-service kiểm tra lessonId có tồn tại không
        LessonResponseDTO lesson = lessonClient.getLessonById(dto.getLessonId()).getData();
        if (lesson == null) {
            throw new IllegalArgumentException("Lesson not found");
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
                .orElseThrow(() -> new IllegalArgumentException("Challenge not found"));
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
            throw new IllegalArgumentException("Challenge not found");
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