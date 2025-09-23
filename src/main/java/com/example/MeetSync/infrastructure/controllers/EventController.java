package com.example.MeetSync.infrastructure.controllers;

import com.example.MeetSync.core.entities.Event;
import com.example.MeetSync.core.usecases.CreateEventUseCase;
import com.example.MeetSync.core.usecases.DeleteEventByIdentifierUseCase;
import com.example.MeetSync.core.usecases.FindEventByIdentifierUseCase;
import com.example.MeetSync.core.usecases.FindEventUseCase;
import com.example.MeetSync.infrastructure.Mapper.EventMapper;
import com.example.MeetSync.infrastructure.dtos.CreateEventoRequestDto;
import com.example.MeetSync.infrastructure.dtos.EventDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/")
public class EventController {

    private final CreateEventUseCase createEventUseCase;
    private final FindEventUseCase findEventUseCase;
    private final FindEventByIdentifierUseCase findEventByIdentifierUseCase;
    private final DeleteEventByIdentifierUseCase deleteEventByIdentifierUseCase;
    private final EventMapper eventMapper;

    public EventController(CreateEventUseCase createEventUseCase, FindEventUseCase findEventUseCase, FindEventByIdentifierUseCase findEventByIdentifierUseCase, DeleteEventByIdentifierUseCase deleteEventByIdentifierUseCase, EventMapper eventMapper) {
        this.createEventUseCase = createEventUseCase;
        this.findEventUseCase = findEventUseCase;
        this.findEventByIdentifierUseCase = findEventByIdentifierUseCase;
        this.deleteEventByIdentifierUseCase = deleteEventByIdentifierUseCase;
        this.eventMapper = eventMapper;
    }

    @PostMapping("createevent")
    public ResponseEntity<Map<String, Object>> createEvent(@RequestBody CreateEventoRequestDto eventDto) {

        CreateEventUseCase.CreateEventInput input = new CreateEventUseCase.CreateEventInput(
                eventDto.name(),
                eventDto.description(),
                eventDto.location(),
                eventDto.startTime(),
                eventDto.endTime(),
                eventDto.capacity(),
                eventDto.type(),
                eventDto.organizer()
        );

        Event newEvent = createEventUseCase.execute(input);
        Map<String, Object> response = Map.of(
                "Message", "Event successfully registered!",
                "Event Data", eventMapper.toDto(newEvent)
        );
        return  ResponseEntity.ok(response);
    }

    @GetMapping("findevent")
    public List<EventDto> eventList(){
        return findEventUseCase.execute().stream().map(eventMapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("findeventbyid/{identifier}")
    public ResponseEntity<EventDto> eventById(@PathVariable String identifier){
        Event newEvent = findEventByIdentifierUseCase.execute(identifier);
        return ResponseEntity.ok(eventMapper.toDto(newEvent));
    }

    @DeleteMapping("deletebyid/{identifier}")
    public ResponseEntity<Map<String, String>> deleteEventById(@PathVariable String identifier){
        deleteEventByIdentifierUseCase.execute(identifier);
        Map<String, String> response = Map.of(
                "Message", "Event with identifier '" + identifier + "' Successfully deleted!"
        );
        return ResponseEntity.ok(response);
    }

}
