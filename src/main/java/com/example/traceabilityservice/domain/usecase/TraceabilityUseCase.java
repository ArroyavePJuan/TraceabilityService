package com.example.traceabilityservice.domain.usecase;

import com.example.traceabilityservice.domain.api.TraceabilityServicePort;
import com.example.traceabilityservice.domain.model.AvgEmployee;
import com.example.traceabilityservice.domain.model.OrderStatus;
import com.example.traceabilityservice.domain.model.OrderTime;
import com.example.traceabilityservice.domain.model.Traceability;
import com.example.traceabilityservice.domain.spi.TraceabilityPersistencePort;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TraceabilityUseCase implements TraceabilityServicePort {

    private final TraceabilityPersistencePort traceabilityPersistencePort;

    public TraceabilityUseCase(TraceabilityPersistencePort traceabilityPersistencePort) {
        this.traceabilityPersistencePort = traceabilityPersistencePort;
    }

    @Override
    public void saveLog(Traceability traceability) {
        traceabilityPersistencePort.saveLog(traceability);
    }

    @Override
    public List<Traceability> findTraceability(Long orderId) {
        return traceabilityPersistencePort.findTraceability(orderId);
    }

    @Override
    public List<OrderTime> findAllTimeOrders() {
        List<Traceability> traceabilityEarringList = traceabilityPersistencePort.findAllTraceabilityAccordingStatus(OrderStatus.EARRING);
        List<Traceability> traceabilityReadyList = traceabilityPersistencePort.findAllTraceabilityAccordingStatus(OrderStatus.READY);
        List<OrderTime> orderTimes = new ArrayList<>();

            for (Traceability traceabilityEarring : traceabilityEarringList){

            for (Traceability traceabilityReady: traceabilityReadyList) {

                if (traceabilityEarring.getOrderId().equals(traceabilityReady.getOrderId())){

                    LocalDateTime datetimeStart = traceabilityEarring.getDate();
                    LocalDateTime dateTimeEnd = traceabilityReady.getDate();

                    Duration duration = Duration.between(datetimeStart, dateTimeEnd);
                    Long minutes = duration.toMinutes();

                    OrderTime orderTime = new OrderTime(traceabilityEarring.getOrderId(),traceabilityReady.getEmployeeId(),minutes);
                    orderTimes.add(orderTime);
                }
            }
        }
        return orderTimes;
    }

    @Override
    public List<AvgEmployee> avgOrderForEmployee(){
        List<OrderTime> orderTimeList = findAllTimeOrders();
        Set<Long> employees = extractUniqueEmployeeIds(orderTimeList);
        List<AvgEmployee> avgOrderTime = new ArrayList<>();

        for (Long employeeId : employees){

            int quantity = 0;
            Long minutes = 0L;

            for (OrderTime orderTime : orderTimeList){

                if (orderTime.getEmployeeId().equals(employeeId)){
                    quantity++;
                    minutes += orderTime.getOrderTimeMinutes();
                }
            }
            Double avg = quantity != 0 ? ((double) minutes) / quantity : 0.0;

            AvgEmployee avgEmployee = new AvgEmployee(employeeId,avg);
            avgOrderTime.add(avgEmployee);
        }
        return avgOrderTime;
    }
    private static Set<Long> extractUniqueEmployeeIds(List<OrderTime> orderTimeList) {
        Set<Long> uniqueEmployeeIds = new HashSet<>();

        for (OrderTime orderTime : orderTimeList) {
            uniqueEmployeeIds.add(orderTime.getEmployeeId());
        }

        return uniqueEmployeeIds;
    }
}
