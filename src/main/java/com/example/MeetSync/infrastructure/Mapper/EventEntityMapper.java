package com.example.MeetSync.infrastructure.Mapper;

import com.example.MeetSync.core.entities.Event;
import com.example.MeetSync.infrastructure.persistence.EventEntity;
import org.springframework.stereotype.Component;

@Component
public class EventEntityMapper {

    public Event toEvent(EventEntity event){
        return new Event(
                event.getId(),
                event.getName(),
                event.getDescription(),
                event.getLocation(),
                event.getIdentifier(),
                event.getStartTime(),
                event.getEndTime(),
                event.getCapacity(),
                event.getType(),
                event.getOrganizer()
        );

    }

    public EventEntity toEventEntity(Event event){
        return new EventEntity(
                event.id(),
                event.name(),
                event.description(),
                event.location(),
                event.identifier(),
                event.startTime(),
                event.endTime(),
                event.capacity(),
                event.type(),
                event.organizer()
        );
    }

}
