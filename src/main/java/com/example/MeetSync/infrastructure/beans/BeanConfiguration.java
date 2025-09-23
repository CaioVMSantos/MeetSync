package com.example.MeetSync.infrastructure.beans;

import com.example.MeetSync.core.gateway.EventGateway;
import com.example.MeetSync.core.gateway.EventIdGenerate;
import com.example.MeetSync.core.usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CreateEventUseCase createEventUseCase(EventGateway eventGateway, EventIdGenerate eventIdGenerate) {
        return new CreateEventUseCaseImpl(eventGateway, eventIdGenerate);
    }

    @Bean
    public FindEventUseCase findEventUseCase(EventGateway eventGateway){
        return new FindEventUseCaseImpl(eventGateway);
    }

    @Bean
    public FindEventByIdentifierUseCase findEventByIdentifierUseCase(EventGateway eventGateway){
        return new FindEventByIdentifierUseCaseImpl(eventGateway);
    }

}
