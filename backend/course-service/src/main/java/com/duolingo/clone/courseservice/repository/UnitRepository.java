package com.duolingo.clone.courseservice.repository;

import com.duolingo.clone.courseservice.entity.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnitRepository extends JpaRepository<Unit, Long> {
}
