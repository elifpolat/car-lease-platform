package com.example.carleaseplatform.application.port.in;

import com.example.carleaseplatform.domain.Car;
import java.util.List;

public interface CarUsecase {

  List<Car> getAllCars();

  Car getCarById(Long id);

  Car saveCar(Car car);

  void deleteCar(Long id);
}
