package com.example.MeetSync.infrastructure.beans;

import com.example.MeetSync.core.gateway.EventGateway;
import com.example.MeetSync.core.usecases.CreateEventUseCase;
import com.example.MeetSync.core.usecases.CreateEventUseCaseImpl;
import com.example.MeetSync.core.usecases.FindEventUseCase;
import com.example.MeetSync.core.usecases.FindEventUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CreateEventUseCase createEventUseCase(EventGateway eventGateway){
        return new CreateEventUseCaseImpl(eventGateway);
    }
    @Bean
    public FindEventUseCase findEventUseCase(EventGateway eventGateway){
        return new FindEventUseCaseImpl(eventGateway);
    }

}
