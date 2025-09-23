package com.example.MeetSync.core.usecases;

import com.example.MeetSync.core.entities.Event;
import com.example.MeetSync.core.enums.EventType;

import java.time.LocalDateTime;

public interface CreateEventUseCase {

    Event execute(CreateEventInput input);

    record CreateEventInput(
            String name,
            String description,
            String location,
            LocalDateTime startTime,
            LocalDateTime endTime,
            Long capacity,
            EventType type,
            String organizer
    ){}

}
