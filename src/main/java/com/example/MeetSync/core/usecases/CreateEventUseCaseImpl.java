package com.example.MeetSync.core.usecases;

import com.example.MeetSync.core.entities.Event;
import com.example.MeetSync.core.gateway.EventGateway;
import com.example.MeetSync.core.gateway.EventIdGenerate;

public class CreateEventUseCaseImpl implements CreateEventUseCase {

    private final EventGateway eventGateway;
    private final EventIdGenerate eventIdGenerate;

    public CreateEventUseCaseImpl(EventGateway eventGateway, EventIdGenerate eventIdGenerate) {
        this.eventGateway = eventGateway;
        this.eventIdGenerate = eventIdGenerate;
    }

    @Override
    public Event execute(CreateEventInput input) {
        String uniqueIdentifier;
        do {
            uniqueIdentifier = eventIdGenerate.generateEventId();
        }while(eventGateway.identifierExists(uniqueIdentifier));
        Event eventToCreate = new Event(
                null,
                input.name(),
                input.description(),
                input.location(),
                uniqueIdentifier,
                input.startTime(),
                input.endTime(),
                input.capacity(),
                input.type(),
                input.organizer()
        );
        return eventGateway.createEvent(eventToCreate);
    }
}
