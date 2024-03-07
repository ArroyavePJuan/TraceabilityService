package com.example.traceabilityservice.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AvgEmployeeResponse {

    private Long employeeId;
    private Double avgMinutes;

}
