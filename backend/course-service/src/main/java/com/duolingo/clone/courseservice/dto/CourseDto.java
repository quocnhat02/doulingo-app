package com.duolingo.clone.courseservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseDto {
    @NotBlank(message = "Course title is required")
    @Size(max = 100, message = "Course title must not exceed 100 characters")
    private String courseTitle;

    @NotBlank(message = "Image URL is required")
    private String courseImageSrc;
}