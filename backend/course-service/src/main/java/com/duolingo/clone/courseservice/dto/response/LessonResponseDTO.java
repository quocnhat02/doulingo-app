package com.duolingo.clone.courseservice.dto.response;

import lombok.*;

import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LessonResponseDTO {
    private Long lessonId;
    private String lessonTitle;
    private int lessonOrder;
    private Long unitId;
}