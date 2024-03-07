package com.example.traceabilityservice.infrastructure.ouput.mongo.repository;

import com.example.traceabilityservice.domain.model.OrderStatus;
import com.example.traceabilityservice.infrastructure.ouput.mongo.entity.TraceabilityEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
public interface TraceabilityRepository extends MongoRepository<TraceabilityEntity,String> {
    List<TraceabilityEntity> findAllByOrderId(Long orderId);
    List<TraceabilityEntity> findAllByNewStatus(OrderStatus newStatus);
}
