package com.duolingo.clone.challengeservice.entity;

import com.duolingo.clone.challengeservice.enums.ChallengeType;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "challenges")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Challenge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "challenge_id")
    private Long challengeId;

    @Column(name = "lesson_id", nullable = false)
    private Long lessonId;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private ChallengeType type;

    @Column(name = "question", nullable = false)
    private String question;

    @Column(name = "challenge_order", nullable = false)
    private Integer challengeOrder;

    @OneToMany(mappedBy = "challenge", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ChallengeOption> challengeOptions = new ArrayList<>();

    @OneToMany(mappedBy = "challenge", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ChallengeProgress> challengeProgresses = new ArrayList<>();
}