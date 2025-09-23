package com.example.MeetSync.core.usecases;

import com.example.MeetSync.core.entities.Event;
import com.example.MeetSync.core.gateway.EventGateway;
import com.example.MeetSync.infrastructure.exception.NotFoundEventException;

public class FindEventByIdentifierUseCaseImpl implements FindEventByIdentifierUseCase {

    EventGateway eventGateway;

    public FindEventByIdentifierUseCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public Event execute(String identifier) {
        return eventGateway.showEventByIdentifier(identifier).orElseThrow(() -> new NotFoundEventException("Event with identifier " + identifier + " not found"));
    }
}
