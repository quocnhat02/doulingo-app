package com.duolingo.clone.challengeservice.entity;

import com.duolingo.clone.challengeservice.enums.ChallengeType;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "challenges", indexes = {
        @Index(name = "idx_challenge_lesson_id", columnList = "lesson_id")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Challenge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "challenge_id") // rõ ràng theo yêu cầu
    private Long challengeId;

    @Column(name = "challenge_question", nullable = false)
    private String challengeQuestion;

    @Column(name = "challenge_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private ChallengeType challengeType;

    @Column(name = "challenge_order", nullable = false)
    private Integer challengeOrder;

    @Column(name = "lesson_id", nullable = false)
    private Long lessonId;

    @OneToMany(mappedBy = "challenge", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<ChallengeOption> challengeOptions;
}