package com.duolingo.clone.challengeservice.entity;

import com.duolingo.clone.challengeservice.enums.ChallengeType;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    private Long challengeId;

    @Column(nullable = false)
    private String question;

    @Column(nullable = false)
    private String type; // e.g. MULTIPLE_CHOICE, FILL_IN_THE_BLANK

    @Column
    private Long lessonId;

    @OneToMany(mappedBy = "challenge", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<ChallengeOption> options = new ArrayList<>();
}