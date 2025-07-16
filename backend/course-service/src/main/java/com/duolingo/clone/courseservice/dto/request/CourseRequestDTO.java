package com.duolingo.clone.courseservice.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CourseRequestDTO {
    @NotBlank
    private String courseTitle;

    @NotBlank
    private String courseImageSrc;
}