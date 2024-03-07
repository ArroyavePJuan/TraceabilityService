package com.example.traceabilityservice.domain.model;

public class AvgEmployee {

    private Long employeeId;
    private Double avgMinutes;

    public AvgEmployee() {
    }

    public AvgEmployee(Long employeeId, Double avgMinutes) {
        this.employeeId = employeeId;
        this.avgMinutes = avgMinutes;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Double getAvgMinutes() {
        return avgMinutes;
    }

    public void setAvgMinutes(Double avgMinutes) {
        this.avgMinutes = avgMinutes;
    }
}
