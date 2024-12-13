package com.example.carleaseplatform.adapter.in.mapper;

import com.example.carleaseplatform.adapter.out.Lease;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = ComponentModel.SPRING, typeConversionPolicy = ReportingPolicy.ERROR)
public interface CarLeaseMapper {

  Lease toDomain(com.example.carleaseplatform.model.LeaseRateRequest leaseRateRequest);

  com.example.carleaseplatform.model.LeaseRateRequest toApi(Lease lease);

}
