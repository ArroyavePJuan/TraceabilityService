package com.example.traceabilityservice.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderTimeResponse {

    private Long orderId;
    private Long employeeId;
    private Long orderTimeMinutes;

}
