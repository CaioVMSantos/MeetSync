package com.example.MeetSync.core.usecases;

import com.example.MeetSync.core.entities.Event;

public interface FindEventByIdentifierUseCase {

    public Event execute(String identifier);

}
