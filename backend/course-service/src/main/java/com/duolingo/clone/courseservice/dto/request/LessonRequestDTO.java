package com.duolingo.clone.courseservice.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LessonRequestDTO {
    @NotBlank
    private String lessonTitle;

    @Min(0)
    private int lessonOrder;

    @NotNull
    private Long unitId;
}