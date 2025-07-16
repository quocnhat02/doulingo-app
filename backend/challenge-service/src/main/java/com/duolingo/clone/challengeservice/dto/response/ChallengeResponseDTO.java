package com.duolingo.clone.challengeservice.dto.response;

import com.duolingo.clone.challengeservice.enums.ChallengeType;
import lombok.Data;

@Data
public class ChallengeResponseDTO {
    private Long challengeId;
    private String challengeQuestion;
    private ChallengeType challengeType;
    private int challengeOrder;
    private Long lessonId;
}