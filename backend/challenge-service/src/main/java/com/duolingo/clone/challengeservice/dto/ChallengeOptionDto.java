package com.duolingo.clone.challengeservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChallengeOptionDto {
    @NotBlank
    private String text;

    @NotNull
    private Boolean correct;

    private String imageSrc;
    private String audioSrc;

    @NotNull
    private Long challengeId;
}
