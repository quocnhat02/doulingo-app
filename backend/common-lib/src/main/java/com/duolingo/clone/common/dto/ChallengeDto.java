package com.duolingo.clone.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChallengeDto {
    private Long id;
    private String type;
    private String question;
    private Long lessonId;
    private Integer order;
}