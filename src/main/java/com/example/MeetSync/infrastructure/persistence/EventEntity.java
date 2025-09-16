package com.example.MeetSync.infrastructure.persistence;

import com.example.MeetSync.core.enums.EventType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name= "Events")
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String location;
    private String identifier;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Long capacity;
    @Enumerated(EnumType.STRING)
    private EventType type;
    private String organizer;
}
