package com.duolingo.clone.courseservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class UnitDto {
    private String unitTitle;
    private String unitDescription;
    private Integer unitOrder;
    private Long courseId;
}