package com.example.carleaseplatform.adapter.in.mapper;

import com.example.carleaseplatform.adapter.out.Car;
import org.springframework.stereotype.Component;
import com.example.carleaseplatform.model.CarApiModel;

@Component
public class CarMapper {

  public Car toDomain(CarApiModel carApiModel) {
    if (carApiModel == null) {
      return null;
    }

    Car car = new Car();
    car.setId(carApiModel.getId());
    car.setBrand(carApiModel.getBrand());
    car.setModel(carApiModel.getModel());
    car.setVersion(carApiModel.getVersion());
    car.setNumberOfDoors(carApiModel.getNumberOfDoors());
    car.setCo2Emission(carApiModel.getCo2Emission());
    car.setGrossPrice(carApiModel.getGrossPrice());
    car.setNettPrice(carApiModel.getNettPrice());

    return car;
  }

  public CarApiModel toApi(Car car) {
    if (car == null) {
      return null;
    }

    CarApiModel carApiModel = new CarApiModel();
    carApiModel.setId(car.getId());
    carApiModel.setBrand(car.getBrand());
    carApiModel.setModel(car.getModel());
    carApiModel.setVersion(car.getVersion());
    carApiModel.setNumberOfDoors(car.getNumberOfDoors());
    carApiModel.setCo2Emission(car.getCo2Emission());
    carApiModel.setGrossPrice(car.getGrossPrice());
    carApiModel.setNettPrice(car.getNettPrice());

    return carApiModel;
  }
}