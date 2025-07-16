package com.duolingo.clone.challengeservice.dto.response;

import lombok.Data;

@Data
public class ChallengeResponseDTO {
    private Long challengeId;
    private String question;
    private String type;
    private Long lessonId;
}