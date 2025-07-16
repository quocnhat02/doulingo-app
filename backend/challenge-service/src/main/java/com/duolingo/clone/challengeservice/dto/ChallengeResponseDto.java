package com.duolingo.clone.challengeservice.dto;

import com.duolingo.clone.challengeservice.enums.ChallengeType;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChallengeResponseDto {
    private Long challengeId;
    private Long lessonId;
    private ChallengeType type;
    private String question;
    private Integer challengeOrder;
}