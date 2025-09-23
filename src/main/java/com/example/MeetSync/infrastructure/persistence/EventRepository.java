package com.example.MeetSync.infrastructure.persistence;

import com.example.MeetSync.core.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventRepository extends JpaRepository<EventEntity, Long> {

    Optional<Event> findByIdentifier(String identifier);
    boolean existsByIdentifier(String identifier);

}
