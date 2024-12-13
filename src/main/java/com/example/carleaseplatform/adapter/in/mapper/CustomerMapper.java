package com.example.carleaseplatform.adapter.in.mapper;

import com.example.carleaseplatform.adapter.out.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = ComponentModel.SPRING, typeConversionPolicy = ReportingPolicy.ERROR)
public interface CustomerMapper {

  Customer toDomain(com.example.carleaseplatform.model.CustomerApiModel customerApiModel);
  com.example.carleaseplatform.model.CustomerApiModel toApi(Customer customerApiModel);

}