package com.duolingo.clone.courseservice.dto;

import jakarta.validation.constraints.Min;
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
public class LessonDto {
    @NotBlank(message = "Lesson title is required")
    private String lessonTitle;

    @NotNull(message = "Lesson order is required")
    @Min(value = 1, message = "Lesson order must be at least 1")
    private Integer lessonOrder;

    @NotNull(message = "Unit ID is required")
    private Long unitId;
}