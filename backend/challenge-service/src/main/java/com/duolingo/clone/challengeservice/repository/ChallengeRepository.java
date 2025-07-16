package com.duolingo.clone.challengeservice.repository;

import com.duolingo.clone.challengeservice.entity.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChallengeRepository extends JpaRepository<Challenge, Long> {
    List<Challenge> findByLessonId(Long lessonId);
}
