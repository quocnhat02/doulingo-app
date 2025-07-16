package com.duolingo.clone.challengeservice.mapper;

import com.duolingo.clone.challengeservice.dto.ChallengeDto;
import com.duolingo.clone.challengeservice.dto.ChallengeResponseDto;
import com.duolingo.clone.challengeservice.entity.Challenge;

public class ChallengeMapper {

    public static Challenge toEntity(ChallengeDto dto) {
        return Challenge.builder()
                .lessonId(dto.getLessonId())
                .type(dto.getType())
                .question(dto.getQuestion())
                .challengeOrder(dto.getChallengeOrder())
                .build();
    }

    public static ChallengeResponseDto toResponseDto(Challenge challenge) {
        return ChallengeResponseDto.builder()
                .challengeId(challenge.getChallengeId())
                .lessonId(challenge.getLessonId())
                .type(challenge.getType())
                .question(challenge.getQuestion())
                .challengeOrder(challenge.getChallengeOrder())
                .build();
    }
}