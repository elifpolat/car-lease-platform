package com.example.carleaseplatform.adapter.in.converter;

import com.example.carleaseplatform.domain.Car;
import com.example.carleaseplatform.model.CarApiModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CarDtoConverter implements Converter<Car, CarApiModel> {

  @Override
  public CarApiModel apply(Car car) {
    if (car == null) {
      throw new IllegalArgumentException("Car must not be null when converting to api dto!");
    }
    return new CarApiModel()
        .id(car.getId())
        .brand(car.getBrand())
        .model(car.getModel())
        .co2Emission(car.getCo2Emission())
        .nettPrice(car.getNettPrice())
        .numberOfDoors(car.getNumberOfDoors())
        .version(car.getVersion())
        .grossPrice(car.getGrossPrice());
  }
}
