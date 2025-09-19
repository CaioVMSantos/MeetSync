package com.example.MeetSync.infrastructure.controllers;

import com.example.MeetSync.core.entities.Event;
import com.example.MeetSync.core.usecases.CreateEventUseCase;
import com.example.MeetSync.core.usecases.FindEventUseCase;
import com.example.MeetSync.infrastructure.Mapper.EventMapper;
import com.example.MeetSync.infrastructure.dtos.EventDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/")
public class EventController {

    private final CreateEventUseCase createEventUseCase;
    private final EventMapper eventMapper;
    private final FindEventUseCase findEventUseCase;

    public EventController(CreateEventUseCase createEventUseCase, EventMapper eventMapper, FindEventUseCase findEventUseCase) {
        this.createEventUseCase = createEventUseCase;
        this.eventMapper = eventMapper;
        this.findEventUseCase = findEventUseCase;
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

}
