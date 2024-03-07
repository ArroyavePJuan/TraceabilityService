package com.example.traceabilityservice.domain.spi;

import com.example.traceabilityservice.domain.model.OrderStatus;
import com.example.traceabilityservice.domain.model.Traceability;

import java.util.List;

public interface TraceabilityPersistencePort {

    void saveLog(Traceability traceability);
    List<Traceability> findTraceability(Long orderId);
    List<Traceability> findAllTraceabilityAccordingStatus(OrderStatus newStatus);


}
