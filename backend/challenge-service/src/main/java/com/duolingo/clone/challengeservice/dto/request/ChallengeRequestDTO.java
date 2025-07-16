package com.duolingo.clone.challengeservice.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ChallengeRequestDTO {
    @NotBlank
    private String question;

    @NotBlank
    private String type;

    @NotNull
    private Long lessonId;
}