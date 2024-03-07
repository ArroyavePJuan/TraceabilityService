package com.example.traceabilityservice.domain.model;

public class OrderTime {
    private Long orderId;
    private Long employeeId;
    private Long orderTimeMinutes;

    public OrderTime() {
    }

    public OrderTime(Long orderId, Long employeeId, Long orderTimeMinutes) {
        this.orderId = orderId;
        this.employeeId = employeeId;
        this.orderTimeMinutes = orderTimeMinutes;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getOrderTimeMinutes() {
        return orderTimeMinutes;
    }

    public void setOrderTimeMinutes(Long orderTimeMinutes) {
        this.orderTimeMinutes = orderTimeMinutes;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }
}
