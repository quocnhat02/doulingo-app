package com.duolingo.clone.challengeservice.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChallengeProgressDto {
    @NotNull
    private String userId;

    @NotNull
    private Long challengeId;

    private Boolean completed;
}