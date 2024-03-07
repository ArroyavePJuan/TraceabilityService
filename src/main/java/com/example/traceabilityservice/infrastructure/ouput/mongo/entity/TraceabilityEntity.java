package com.example.traceabilityservice.infrastructure.ouput.mongo.entity;

import com.example.traceabilityservice.domain.model.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "traceability")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TraceabilityEntity {

    @Id
    private String id;
    private Long orderId;
    private Long customerId;
    private String customerMail;
    private LocalDateTime date;
    private OrderStatus previousStatus;
    private OrderStatus newStatus;
    private Long employeeId;
    private String employeeMail;

}
