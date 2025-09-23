package com.example.MeetSync.infrastructure.dtos;

import com.example.MeetSync.core.enums.EventType;

import java.time.LocalDateTime;

public record CreateEventoRequestDto(
        String name,
        String description,
        String location,
        LocalDateTime startTime,
        LocalDateTime endTime,
        Long capacity,
        EventType type,
        String organizer
) {
}
