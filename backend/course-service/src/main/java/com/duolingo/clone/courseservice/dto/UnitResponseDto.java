package com.duolingo.clone.courseservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UnitResponseDto {
    private Long unitId;
    private String unitTitle;
    private String unitDescription;
    private Integer unitOrder;
    private Long courseId;
}