package com.example.traceabilityservice.application.mapper;

import com.example.traceabilityservice.application.dto.OrderTimeResponse;
import com.example.traceabilityservice.application.dto.TraceabilityRequest;
import com.example.traceabilityservice.application.dto.TraceabilityResponse;
import com.example.traceabilityservice.domain.model.OrderTime;
import com.example.traceabilityservice.domain.model.Traceability;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ITraceabilityMapper {

    Traceability toTraceability(TraceabilityRequest traceabilityRequest);
    TraceabilityResponse toTraceabilityResponse(Traceability traceability);
    List<TraceabilityResponse> toTraceabilityList (List<Traceability> traceabilities);
    OrderTimeResponse toOrderTime(OrderTime orderTime);
    List<OrderTimeResponse> toOrderResponseList(List<OrderTime> orderTimeList);

}
