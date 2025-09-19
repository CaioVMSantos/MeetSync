package com.example.MeetSync.core.usecases;

import com.example.MeetSync.core.entities.Event;
import com.example.MeetSync.core.gateway.EventGateway;
import com.example.MeetSync.infrastructure.exception.DuplicateEventException;

public class CreateEventUseCaseImpl implements CreateEventUseCase {

    private final EventGateway eventGateway;

    public CreateEventUseCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public Event execute(Event event) {
        if (eventGateway.identifierExists(event.identifier())){
            throw new DuplicateEventException("The Identifier "+event.identifier() +" already exists!");
        }
        return eventGateway.createEvent(event);
    }
}
