package com.duolingo.clone.challengeservice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "challenge_options", indexes = {
        @Index(name = "idx_option_challenge_id", columnList = "challenge_id")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChallengeOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "challenge_option_id")
    private Long challengeOptionId;

    @Column(name = "option_text", nullable = false)
    private String optionText;

    @Column(name = "is_correct", nullable = false)
    private boolean isCorrect;

    @Column(name = "image_src")
    private String imageSrc;

    @Column(name = "audio_src")
    private String audioSrc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "challenge_id", nullable = false)
    @JsonBackReference
    private Challenge challenge;
}