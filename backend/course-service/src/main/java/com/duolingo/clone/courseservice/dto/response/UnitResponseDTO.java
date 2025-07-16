package com.duolingo.clone.courseservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UnitResponseDTO {
    private Long unitId;
    private String unitTitle;
    private String unitDescription;
    private int unitOrder;
    private Long courseId;
}