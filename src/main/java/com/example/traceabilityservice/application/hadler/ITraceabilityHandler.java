package com.example.traceabilityservice.application.hadler;

import com.example.traceabilityservice.application.dto.AvgEmployeeResponse;
import com.example.traceabilityservice.application.dto.OrderTimeResponse;
import com.example.traceabilityservice.application.dto.TraceabilityRequest;
import com.example.traceabilityservice.application.dto.TraceabilityResponse;

import java.util.List;

public interface ITraceabilityHandler
{
    void saveLog (TraceabilityRequest traceabilityRequest);
    List<TraceabilityResponse> findTraceability(Long orderId);
    List<OrderTimeResponse> findAllTimeOrders();
    List<AvgEmployeeResponse> avgOrderForEmployee();
}
