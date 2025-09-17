package com.example.MeetSync.infrastructure.controllers;

import com.example.MeetSync.core.entities.Event;
import com.example.MeetSync.core.usecases.CreateEventUseCase;
import com.example.MeetSync.infrastructure.Mapper.EventMapper;
import com.example.MeetSync.infrastructure.dtos.EventDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
public class EventController {

    CreateEventUseCase createEventUseCase;
    EventMapper eventMapper;

    @PostMapping("createevent")
    public EventDto createEvent(@RequestBody EventDto eventDto) {
        Event newEvent = createEventUseCase.execute(eventMapper.toEntity(eventDto));
        return eventMapper.toDto(newEvent);
    }

    @GetMapping("findevent")
    public String eventList(){
    return "Lista de eventos";
    }

}
