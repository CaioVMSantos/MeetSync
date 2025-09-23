package com.example.MeetSync.core.usecases;

import com.example.MeetSync.core.gateway.EventGateway;
import com.example.MeetSync.infrastructure.exception.NotFoundEventException;

public class DeleteEventByIdentifierUseCaseImpl implements DeleteEventByIdentifierUseCase {

    private final EventGateway eventGateway;

    public DeleteEventByIdentifierUseCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public void execute(String identifier) {
        if(!eventGateway.identifierExists(identifier)){
            throw new NotFoundEventException("Event with identifier " + identifier + " does not exist");
        }
        eventGateway.deleteEventByIdentifier(identifier);
    }
}
