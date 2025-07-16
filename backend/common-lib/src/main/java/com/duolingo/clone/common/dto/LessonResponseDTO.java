package com.duolingo.clone.common.dto;

import lombok.Data;

@Data
public class LessonResponseDTO {
    private Long lessonId;
    private String lessonTitle;
    private int lessonOrder;
    private Long unitId;
}