package com.duolingo.clone.challengeservice.dto.response;

import lombok.Data;

@Data
public class ChallengeOptionResponseDTO {
    private Long challengeOptionId;
    private String content;
    private boolean isCorrect;
    private Long challengeId;
}