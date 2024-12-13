package com.example.carleaseplatform.adapter.in.mapper;

import com.example.carleaseplatform.domain.Lease;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = ComponentModel.SPRING, typeConversionPolicy = ReportingPolicy.ERROR)
public interface CarLeaseMapper {

  Lease toDomain(com.example.carleaseplatform.model.LeaseRateRequest leaseRateRequest);


}