package com.example.MeetSync.infrastructure.Mapper;

import com.example.MeetSync.core.entities.Event;
import com.example.MeetSync.infrastructure.dtos.EventDto;
import org.springframework.stereotype.Component;

@Component
public class EventMapper {

    public EventDto toDto(Event event){
        return new EventDto(
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

    public Event toEntity(EventDto eventDto){
        return new Event(
                eventDto.id(),
                eventDto.name(),
                eventDto.description(),
                eventDto.location(),
                eventDto.identifier(),
                eventDto.startTime(),
                eventDto.endTime(),
                eventDto.capacity(),
                eventDto.type(),
                eventDto.organizer()
        );
    }

}
