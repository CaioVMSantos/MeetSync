package com.example.MeetSync.infrastructure.gateway;

import com.example.MeetSync.core.entities.Event;
import com.example.MeetSync.core.gateway.EventGateway;
import com.example.MeetSync.infrastructure.Mapper.EventEntityMapper;
import com.example.MeetSync.infrastructure.persistence.EventEntity;
import com.example.MeetSync.infrastructure.persistence.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EventRepositoryGateway implements EventGateway {

    private final EventRepository eventRepository;
    private final EventEntityMapper eventMapper;

    @Override
    public Event createEvent(Event event) {
        EventEntity newEvent = eventRepository.save(eventMapper.toEventEntity(event));
        return eventMapper.toEvent(newEvent);
    }

    @Override
    public List<Event> showEvents() {
        return eventRepository.findAll().stream().map(eventMapper::toEvent).toList();
    }

    @Override
    public boolean identifierExists(String identifier) {
        return eventRepository.findAll().stream().anyMatch(event -> event.getIdentifier().equals(identifier));
    }
}
