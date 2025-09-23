package com.example.MeetSync.infrastructure.gateway;

import com.example.MeetSync.core.entities.Event;
import com.example.MeetSync.core.gateway.EventGateway;
import com.example.MeetSync.infrastructure.Mapper.EventEntityMapper;
import com.example.MeetSync.infrastructure.persistence.EventEntity;
import com.example.MeetSync.infrastructure.persistence.EventRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EventRepositoryGateway implements EventGateway {

    private final EventRepository eventRepository;
    private final EventEntityMapper eventMapper;

    public EventRepositoryGateway(EventRepository eventRepository, EventEntityMapper eventMapper) {
        this.eventRepository = eventRepository;
        this.eventMapper = eventMapper;
    }

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
    public Optional<Event> showEventByIdentifier(String identifier) {
        return eventRepository.findByIdentifier(identifier);
    }

    @Override
    public void deleteEventByIdentifier(String identifier) {
        eventRepository.deleteByIdentifier(identifier);
    }

    @Override
    public boolean identifierExists(String identifier) {
        return eventRepository.existsByIdentifier(identifier);
    }
}
