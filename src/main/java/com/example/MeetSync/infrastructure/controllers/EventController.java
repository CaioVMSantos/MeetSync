package com.example.MeetSync.infrastructure.controllers;

import com.example.MeetSync.core.entities.Event;
import com.example.MeetSync.core.usecases.CreateEventUseCase;
import com.example.MeetSync.core.usecases.FindEventByIdentifierUseCase;
import com.example.MeetSync.core.usecases.FindEventUseCase;
import com.example.MeetSync.infrastructure.Mapper.EventMapper;
import com.example.MeetSync.infrastructure.dtos.EventDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/")
public class EventController {

    private final CreateEventUseCase createEventUseCase;
    private final FindEventUseCase findEventUseCase;
    private final FindEventByIdentifierUseCase findEventByIdentifierUseCase;
    private final EventMapper eventMapper;

    public EventController(CreateEventUseCase createEventUseCase, FindEventUseCase findEventUseCase, FindEventByIdentifierUseCase findEventByIdentifierUseCase, EventMapper eventMapper) {
        this.createEventUseCase = createEventUseCase;
        this.findEventUseCase = findEventUseCase;
        this.findEventByIdentifierUseCase = findEventByIdentifierUseCase;
        this.eventMapper = eventMapper;
    }

    @PostMapping("createevent")
    public ResponseEntity<Map<String, Object>> createEvent(@RequestBody EventDto eventDto) {
        Event newEvent = createEventUseCase.execute(eventMapper.toEntity(eventDto));
        Map<String, Object> response = new HashMap<>();
        response.put("Mensagem: ", "Evento cadastrado com sucesso, no nosso banco de dados!");
        response.put("Dados do Evento", eventMapper.toDto(newEvent) );
        return ResponseEntity.ok(response);
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

}
