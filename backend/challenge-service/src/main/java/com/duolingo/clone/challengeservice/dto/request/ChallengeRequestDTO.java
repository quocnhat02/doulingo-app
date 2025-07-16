package com.duolingo.clone.challengeservice.dto.request;

import com.duolingo.clone.challengeservice.enums.ChallengeType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ChallengeRequestDTO {

    @NotNull
    private Long lessonId;

    @NotNull(message = "Challenge type must not be null")
    private ChallengeType challengeType;

    @NotBlank
    private String challengeQuestion;

    @Min(0)
    private int challengeOrder;
}