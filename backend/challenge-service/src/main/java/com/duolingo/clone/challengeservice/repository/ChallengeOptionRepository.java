package com.duolingo.clone.challengeservice.repository;

import com.duolingo.clone.challengeservice.entity.ChallengeOption;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChallengeOptionRepository extends JpaRepository<ChallengeOption, Long> {
    List<ChallengeOption> findByChallengeId(Long challengeId);
}