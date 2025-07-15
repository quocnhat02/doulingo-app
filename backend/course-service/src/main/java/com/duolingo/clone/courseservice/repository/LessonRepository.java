package com.duolingo.clone.courseservice.repository;

import com.duolingo.clone.courseservice.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
