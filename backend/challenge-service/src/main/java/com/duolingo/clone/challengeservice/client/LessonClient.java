package com.duolingo.clone.challengeservice.client;

import com.duolingo.clone.common.dto.LessonResponseDTO;
import com.duolingo.clone.common.response.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "course-service")
public interface LessonClient {
    @GetMapping("/api/lessons/{lessonId}")
    ApiResponse<LessonResponseDTO> getLessonById(@PathVariable("lessonId") Long lessonId);
}