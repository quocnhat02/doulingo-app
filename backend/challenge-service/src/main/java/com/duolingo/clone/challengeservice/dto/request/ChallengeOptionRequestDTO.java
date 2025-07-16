package com.duolingo.clone.challengeservice.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ChallengeOptionRequestDTO {

    @NotBlank
    private String optionText;

    private String imageSrc;

    private String audioSrc;

    private boolean isCorrect;

    @NotNull
    private Long challengeId;
}