package com.example.MeetSync.core.usecases;
import com.example.MeetSync.core.entities.Event;

import java.util.List;

public interface FindEventUseCase {

    public List<Event> execute();
}
