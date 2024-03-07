package com.example.traceabilityservice.infrastructure.ouput.mongo.adapter;

import com.example.traceabilityservice.domain.model.OrderStatus;
import com.example.traceabilityservice.domain.model.Traceability;
import com.example.traceabilityservice.domain.spi.TraceabilityPersistencePort;
import com.example.traceabilityservice.infrastructure.ouput.mongo.mapper.TraceabilityEntityMapper;
import com.example.traceabilityservice.infrastructure.ouput.mongo.repository.TraceabilityRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class TraceabilityAdapter implements TraceabilityPersistencePort {

    private final TraceabilityRepository traceabilityRepository;
    private final TraceabilityEntityMapper traceabilityEntityMapper;
    @Override
    public void saveLog(Traceability traceability) {
        traceabilityRepository.save(traceabilityEntityMapper.toTraceabilityEntity(traceability));
    }

    @Override
    public List<Traceability> findTraceability(Long orderId) {
        return traceabilityEntityMapper.toTraceabilityList(traceabilityRepository.findAllByOrderId(orderId));
    }

    @Override
    public List<Traceability> findAllTraceabilityAccordingStatus(OrderStatus newStatus) {
        return traceabilityEntityMapper.toTraceabilityList(traceabilityRepository.findAllByNewStatus(newStatus));
    }


}
