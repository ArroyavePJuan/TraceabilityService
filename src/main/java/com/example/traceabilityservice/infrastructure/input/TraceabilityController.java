package com.example.traceabilityservice.infrastructure.input;

import com.example.traceabilityservice.application.dto.AvgEmployeeResponse;
import com.example.traceabilityservice.application.dto.OrderTimeResponse;
import com.example.traceabilityservice.application.dto.TraceabilityRequest;
import com.example.traceabilityservice.application.dto.TraceabilityResponse;
import com.example.traceabilityservice.application.hadler.ITraceabilityHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/traceability/")
@RequiredArgsConstructor
public class TraceabilityController {

    private final ITraceabilityHandler traceabilityHandler;
    @PostMapping("saveLog")
    public ResponseEntity<Void> saveLog(@RequestBody TraceabilityRequest traceabilityRequest){
        traceabilityHandler.saveLog(traceabilityRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("findTraceability/{orderId}")
    public ResponseEntity<List<TraceabilityResponse>> findTraceability(@PathVariable Long orderId){
        return ResponseEntity.ok(traceabilityHandler.findTraceability(orderId));
    }

    @GetMapping("findAll/timeOrders")
    public ResponseEntity<List<OrderTimeResponse>> findAllTimeOrders(){
        return ResponseEntity.ok(traceabilityHandler.findAllTimeOrders());
    }
    @GetMapping("averageEmployee")
    public ResponseEntity<List<AvgEmployeeResponse>> avgOrderForEmployee(){
        return ResponseEntity.ok(traceabilityHandler.avgOrderForEmployee());
    }


}
