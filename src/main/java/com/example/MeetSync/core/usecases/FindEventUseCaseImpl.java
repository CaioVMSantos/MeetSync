package com.example.MeetSync.core.usecases;

import com.example.MeetSync.core.entities.Event;
import com.example.MeetSync.core.gateway.EventGateway;

import java.util.List;

public class FindEventUseCaseImpl implements FindEventUseCase {

    private final EventGateway  eventGateway;

    public FindEventUseCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public List<Event> execute() {
        return eventGateway.showEvents();
    }
}
