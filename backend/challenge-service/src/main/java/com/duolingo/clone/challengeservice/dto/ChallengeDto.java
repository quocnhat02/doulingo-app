package com.duolingo.clone.challengeservice.dto;

import com.duolingo.clone.challengeservice.enums.ChallengeType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChallengeDto {
    @NotNull
    private Long lessonId;
    @NotNull
    private ChallengeType type;
    @NotBlank
    private String question;
    @NotNull
    private Integer challengeOrder;
}