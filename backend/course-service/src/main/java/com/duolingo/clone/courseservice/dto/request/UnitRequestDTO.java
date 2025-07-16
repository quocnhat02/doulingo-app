package com.duolingo.clone.courseservice.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UnitRequestDTO {
    @NotBlank
    private String unitTitle;

    private String unitDescription;

    @Min(0)
    private int unitOrder;

    @NotNull
    private Long courseId;
}
