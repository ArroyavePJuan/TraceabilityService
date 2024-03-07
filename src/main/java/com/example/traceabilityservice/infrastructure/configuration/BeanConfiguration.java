package com.example.traceabilityservice.infrastructure.configuration;

import com.example.traceabilityservice.domain.api.TraceabilityServicePort;
import com.example.traceabilityservice.domain.spi.TraceabilityPersistencePort;
import com.example.traceabilityservice.domain.usecase.TraceabilityUseCase;
import com.example.traceabilityservice.infrastructure.ouput.mongo.adapter.TraceabilityAdapter;
import com.example.traceabilityservice.infrastructure.ouput.mongo.mapper.TraceabilityEntityMapper;
import com.example.traceabilityservice.infrastructure.ouput.mongo.repository.TraceabilityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final TraceabilityRepository traceabilityRepository;
    private final TraceabilityEntityMapper traceabilityEntityMapper;
    @Bean
    public TraceabilityPersistencePort traceabilityPersistencePort() {
        return new TraceabilityAdapter(traceabilityRepository,traceabilityEntityMapper);
    }
    @Bean
    public TraceabilityServicePort traceabilityServicePort() {return new TraceabilityUseCase(traceabilityPersistencePort());
    }

}
