package com.duolingo.clone.courseservice.repository;

import com.duolingo.clone.courseservice.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
