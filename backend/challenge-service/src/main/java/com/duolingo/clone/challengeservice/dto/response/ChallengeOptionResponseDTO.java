package com.duolingo.clone.challengeservice.dto.response;

import lombok.Data;

@Data
public class ChallengeOptionResponseDTO {

    private Long challengeOptionId;
    private String optionText;
    private boolean isCorrect;
    private String imageSrc;
    private String audioSrc;
    private Long challengeId;
}