package com.example.MeetSync.core.gateway;
import com.example.MeetSync.core.entities.Event;

import java.util.List;
import java.util.Optional;

public interface EventGateway {

    Event createEvent(Event event);
    List<Event> showEvents();
    Optional<Event> showEventByIdentifier(String identifier);
    boolean identifierExists(String identifier);


}
