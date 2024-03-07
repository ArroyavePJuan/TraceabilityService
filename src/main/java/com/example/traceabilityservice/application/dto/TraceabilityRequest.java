package com.example.traceabilityservice.application.dto;

import com.example.traceabilityservice.domain.model.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TraceabilityRequest {
    private Long orderId;
    private Long customerId;
    private String customerMail;
    private LocalDateTime date;
    private OrderStatus previousStatus;
    private OrderStatus newStatus;
    private Long employeeId;
    private String employeeMail;
}
