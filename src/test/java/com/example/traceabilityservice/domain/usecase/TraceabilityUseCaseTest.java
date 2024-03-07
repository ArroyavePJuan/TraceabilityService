package com.example.traceabilityservice.domain.usecase;

import com.example.traceabilityservice.domain.model.AvgEmployee;
import com.example.traceabilityservice.domain.model.OrderStatus;
import com.example.traceabilityservice.domain.model.OrderTime;
import com.example.traceabilityservice.domain.model.Traceability;
import com.example.traceabilityservice.domain.spi.TraceabilityPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TraceabilityUseCaseTest {

    @Mock
    private TraceabilityPersistencePort traceabilityPersistencePort;

    @InjectMocks
    private TraceabilityUseCase traceabilityUseCase;

    private Traceability traceability;
    private OrderTime orderTime;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        traceability = new Traceability();
        traceability.setOrderId(1L);
        traceability.setDate(LocalDateTime.now());
        traceability.setCustomerId(1L);
        traceability.setCustomerMail("mail@mail");
        traceability.setEmployeeId(1L);
        traceability.setEmployeeMail("mail@mail.com");
        traceability.setPreviousStatus(OrderStatus.EARRING);
        traceability.setNewStatus(OrderStatus.IN_PREPARATION);

        orderTime = new OrderTime();
        orderTime.setOrderId(1L);
        orderTime.setEmployeeId(1L);
        orderTime.setOrderTimeMinutes(14L);
    }

    @Test
    void saveLog() {
        traceabilityUseCase.saveLog(traceability);
        verify(traceabilityPersistencePort).saveLog(traceability);
    }

    @Test
    void findTraceability() {
        List<Traceability> traceabilities = new ArrayList<>();
        traceabilities.add(traceability);
        when(traceabilityPersistencePort.findTraceability(1L)).thenReturn(traceabilities);
        assertNotNull(traceabilityUseCase.findTraceability(1L));
    }

    @Test
    void findAllTimeOrders() {

        List<OrderTime> result = traceabilityUseCase.findAllTimeOrders();
        verify(traceabilityPersistencePort, times(1))
                .findAllTraceabilityAccordingStatus(OrderStatus.EARRING);

        verify(traceabilityPersistencePort, times(1))
                .findAllTraceabilityAccordingStatus(OrderStatus.READY);

        assertNotNull(result);
    }

    @Test
    void avgOrderForEmployee() {
        List<OrderTime> orderTimeList = new ArrayList<>();
        OrderTime orderTime1 = new OrderTime(1L, 1L, 4L);
        OrderTime orderTime2 = new OrderTime(1L, 1L, 6L);
        orderTimeList.add(orderTime1);
        orderTimeList.add(orderTime2);

        when(traceabilityUseCase.findAllTimeOrders()).thenReturn(orderTimeList);

        List<AvgEmployee> result = traceabilityUseCase.avgOrderForEmployee();
        for (OrderTime orderTime3 : orderTimeList){
            System.out.println(orderTime3.getEmployeeId());
            System.out.println(orderTime3.getOrderId());
            System.out.println(orderTime3.getOrderTimeMinutes());
        }
        System.out.println(result + "resultado");
        assertNotNull(result);

        AvgEmployee avgEmployee = result.get(0);

        assertEquals(1L, avgEmployee.getEmployeeId());
        assertEquals(10.0, avgEmployee.getAvgMinutes(), 0.01);
        verify(traceabilityUseCase, times(1)).findAllTimeOrders();
    }
}