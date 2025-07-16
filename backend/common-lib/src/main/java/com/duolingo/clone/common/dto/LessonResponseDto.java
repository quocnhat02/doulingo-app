package com.duolingo.clone.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LessonResponseDto {
    private Long lessonId;
    private String lessonTitle;
    private Integer lessonOrder;
    private Long unitId;
}