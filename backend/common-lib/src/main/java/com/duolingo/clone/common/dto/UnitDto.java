package com.duolingo.clone.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UnitDto {
    private Long id;
    private String title;
    private String description;
    private Long courseId;
    private Integer order;
}