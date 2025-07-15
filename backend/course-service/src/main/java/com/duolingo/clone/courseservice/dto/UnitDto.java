package com.duolingo.clone.courseservice.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UnitDto {
    @NotBlank(message = "Unit title is required")
    private String unitTitle;

    @NotBlank(message = "Unit description is required")
    private String unitDescription;

    @NotNull(message = "Unit order is required")
    @Min(value = 1, message = "Unit order must be at least 1")
    private Integer unitOrder;

    @NotNull(message = "Course ID is required")
    private Long courseId;
}