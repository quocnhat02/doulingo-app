package com.duolingo.clone.courseservice.repository;

import com.duolingo.clone.courseservice.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByCourseTitleContainingIgnoreCase(String title);
    Page<Course> findAll(Pageable pageable);
}
