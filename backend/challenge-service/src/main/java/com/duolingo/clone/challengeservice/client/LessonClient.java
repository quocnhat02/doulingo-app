package com.duolingo.clone.challengeservice.client;

import com.duolingo.clone.common.dto.LessonResponseDto;
import com.duolingo.clone.common.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class LessonClient {

    private final RestTemplate restTemplate;

    public LessonResponseDto getLessonById(Long lessonId) {
        try {
            return restTemplate.getForObject("http://localhost:8081" + "/api/lessons/" + lessonId, LessonResponseDto.class);
        } catch (HttpClientErrorException.NotFound e) {
            throw new ResourceNotFoundException("Lesson not found with id: " + lessonId);
        }
    }
}