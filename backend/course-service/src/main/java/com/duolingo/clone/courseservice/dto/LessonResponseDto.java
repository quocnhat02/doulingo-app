package com.duolingo.clone.courseservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LessonResponseDto {
    private Long lessonId;
    private String lessonTitle;
    private Integer lessonOrder;
    private Long unitId;
}