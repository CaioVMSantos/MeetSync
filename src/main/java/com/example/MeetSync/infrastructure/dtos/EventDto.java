package com.example.MeetSync.infrastructure.dtos;
import com.example.MeetSync.core.enums.EventType;
import java.time.LocalDateTime;

public record EventDto(
        Long id,
        String name,
        String description,
        String location,
        String identifier,
        LocalDateTime startTime,
        LocalDateTime endTime,
        Long capacity,
        EventType type,
        String organizer
) {}
