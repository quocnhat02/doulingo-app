package com.duolingo.clone.courseservice.repository;

import com.duolingo.clone.courseservice.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByCourseTitleContainingIgnoreCase(String title);
    List<Course> findAll(Pageable pageable);
}
