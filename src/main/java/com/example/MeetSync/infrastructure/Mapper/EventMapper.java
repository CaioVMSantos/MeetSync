package com.example.MeetSync.infrastructure.Mapper;

import com.example.MeetSync.infrastructure.dtos.EventDto;
import com.example.MeetSync.infrastructure.persistence.EventEntity;
import org.springframework.stereotype.Component;

@Component
public class EventMapper {

    public EventDto toDto(EventEntity event){
        if(event == null){
            return null;
        }
        return new EventDto(
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

    public EventEntity toEntity(EventDto eventDto){
        if(eventDto == null){
            return null;
        }
        return new EventEntity(
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
