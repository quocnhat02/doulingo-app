package com.duolingo.clone.common.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventBase {
    private String eventId;
    private Instant timestamp;
    private String eventType;
}