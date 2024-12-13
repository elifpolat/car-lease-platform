package com.example.carleaseplatform.adapter.in.mapper;

import com.example.carleaseplatform.adapter.out.Car;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = ComponentModel.SPRING, typeConversionPolicy = ReportingPolicy.ERROR)
public interface CarMapper {

  Car toDomain(com.example.carleaseplatform.model.CarApiModel car);

  com.example.carleaseplatform.model.CarApiModel toApi(Car car);
}