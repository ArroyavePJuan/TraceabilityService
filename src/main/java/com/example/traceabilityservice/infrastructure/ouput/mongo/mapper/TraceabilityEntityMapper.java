package com.example.traceabilityservice.infrastructure.ouput.mongo.mapper;

import com.example.traceabilityservice.domain.model.Traceability;
import com.example.traceabilityservice.infrastructure.ouput.mongo.entity.TraceabilityEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TraceabilityEntityMapper {

    TraceabilityEntity toTraceabilityEntity(Traceability traceability);
    Traceability toTraceability(TraceabilityEntity traceabilityEntity);
    List<Traceability> toTraceabilityList(List<TraceabilityEntity> traceabilityEntities);

}
