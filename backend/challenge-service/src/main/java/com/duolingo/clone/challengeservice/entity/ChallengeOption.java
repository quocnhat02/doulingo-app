package com.duolingo.clone.challengeservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "challenge_options")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChallengeOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "challenge_option_id")
    private Long challengeOptionId;

    @Column(name = "text", nullable = false)
    private String text;

    @Column(name = "correct", nullable = false)
    private Boolean correct;

    @Column(name = "image_src")
    private String imageSrc;

    @Column(name = "audio_src")
    private String audioSrc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "challenge_id", nullable = false)
    private Challenge challenge;
}