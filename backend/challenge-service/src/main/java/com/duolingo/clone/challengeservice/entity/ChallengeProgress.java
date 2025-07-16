package com.duolingo.clone.challengeservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "challenge_progress")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChallengeProgress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "progress_id")
    private Long progressId;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "completed", nullable = false)
    private Boolean completed;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "challenge_id", nullable = false)
    private Challenge challenge;
}