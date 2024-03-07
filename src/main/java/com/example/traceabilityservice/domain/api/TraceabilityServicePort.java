package com.example.traceabilityservice.domain.api;

import com.example.traceabilityservice.domain.model.AvgEmployee;
import com.example.traceabilityservice.domain.model.OrderTime;
import com.example.traceabilityservice.domain.model.Traceability;

import java.util.List;

public interface TraceabilityServicePort {
    void saveLog (Traceability traceability);
    List<Traceability> findTraceability(Long orderId);
    List<OrderTime> findAllTimeOrders();
    List<AvgEmployee> avgOrderForEmployee();

}
