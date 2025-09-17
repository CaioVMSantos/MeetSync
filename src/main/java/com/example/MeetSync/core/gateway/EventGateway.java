package com.example.MeetSync.core.gateway;
import com.example.MeetSync.core.entities.Event;

import java.util.List;

public interface EventGateway {

    Event createEvent(Event event);
    List<Event> showEvents();

}
