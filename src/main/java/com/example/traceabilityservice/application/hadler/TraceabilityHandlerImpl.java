package com.example.traceabilityservice.application.hadler;

import com.example.traceabilityservice.application.dto.AvgEmployeeResponse;
import com.example.traceabilityservice.application.dto.OrderTimeResponse;
import com.example.traceabilityservice.application.dto.TraceabilityRequest;
import com.example.traceabilityservice.application.dto.TraceabilityResponse;
import com.example.traceabilityservice.application.mapper.AvgEmployeeMapper;
import com.example.traceabilityservice.application.mapper.ITraceabilityMapper;
import com.example.traceabilityservice.domain.api.TraceabilityServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TraceabilityHandlerImpl implements ITraceabilityHandler{

    private final TraceabilityServicePort traceabilityServicePort;
    private final ITraceabilityMapper traceabilityMapper;
    private final AvgEmployeeMapper avgEmployeeMapper;
    @Override
    public void saveLog(TraceabilityRequest traceabilityRequest) {
        traceabilityServicePort.saveLog(traceabilityMapper.toTraceability(traceabilityRequest));
    }

    @Override
    public List<TraceabilityResponse> findTraceability(Long orderId) {
        return traceabilityMapper.toTraceabilityList(traceabilityServicePort.findTraceability(orderId));
    }

    @Override
    public List<OrderTimeResponse> findAllTimeOrders() {
        return traceabilityMapper.toOrderResponseList(traceabilityServicePort.findAllTimeOrders());
    }

    @Override
    public List<AvgEmployeeResponse> avgOrderForEmployee() {
        return avgEmployeeMapper.toResponses(traceabilityServicePort.avgOrderForEmployee());
    }
}
