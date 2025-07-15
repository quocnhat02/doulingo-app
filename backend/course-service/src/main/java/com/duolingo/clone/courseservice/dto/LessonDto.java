package com.duolingo.clone.courseservice.dto;

import lombok.Data;

@Data
public class LessonDto {
    private String lessonTitle;
    private Integer lessonOrder;
    private Long unitId;
}