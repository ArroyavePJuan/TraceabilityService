package com.example.traceabilityservice.infrastructure.ouput.mongo.adapter;

import com.example.traceabilityservice.domain.model.OrderStatus;
import com.example.traceabilityservice.domain.model.Traceability;
import com.example.traceabilityservice.infrastructure.ouput.mongo.entity.TraceabilityEntity;
import com.example.traceabilityservice.infrastructure.ouput.mongo.mapper.TraceabilityEntityMapper;
import com.example.traceabilityservice.infrastructure.ouput.mongo.repository.TraceabilityRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TraceabilityAdapterTest {
    @Mock
    private TraceabilityRepository traceabilityRepository;
    @Mock
    private TraceabilityEntityMapper traceabilityEntityMapper;
    @InjectMocks
    private TraceabilityAdapter traceabilityAdapter;
    private Traceability traceability;
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
    }

    @Test
    void saveLog() {
        traceabilityAdapter.saveLog(traceability);
        Mockito.verify(traceabilityRepository, Mockito.times(1)).save(traceabilityEntityMapper.toTraceabilityEntity(traceability));
    }

    @Test
    void findTraceability() {
        List<TraceabilityEntity> traceabilities = new ArrayList<>();
        traceabilities.add(traceabilityEntityMapper.toTraceabilityEntity(traceability));

        Mockito.when(traceabilityRepository.findAllByOrderId(1L)).thenReturn(traceabilities);
        List<Traceability> logs = traceabilityAdapter.findTraceability(1L);
        assertEquals(logs, traceabilityEntityMapper.toTraceabilityList(traceabilities));
    }

    @Test
    void findAllTraceabilityAccordingStatus() {
        List<TraceabilityEntity> traceabilities = new ArrayList<>();
        traceabilities.add(traceabilityEntityMapper.toTraceabilityEntity(traceability));

        Mockito.when(traceabilityRepository.findAllByNewStatus(OrderStatus.EARRING)).thenReturn(traceabilities);
        List<Traceability> logs = traceabilityAdapter.findAllTraceabilityAccordingStatus(OrderStatus.EARRING);
        assertEquals(logs, traceabilityEntityMapper.toTraceabilityList(traceabilities));
    }
}