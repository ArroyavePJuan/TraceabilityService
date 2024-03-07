package com.example.traceabilityservice.application.mapper;

import com.example.traceabilityservice.application.dto.AvgEmployeeResponse;
import com.example.traceabilityservice.domain.model.AvgEmployee;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AvgEmployeeMapper {

    AvgEmployeeResponse toResponse (AvgEmployee avgEmployee);
    List<AvgEmployeeResponse> toResponses (List<AvgEmployee> avgEmployee);

}
