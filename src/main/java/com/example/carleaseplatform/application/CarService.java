package com.example.carleaseplatform.application;

import com.example.carleaseplatform.domain.Car;
import com.example.carleaseplatform.domain.exception.CarNotFoundException;
import com.example.carleaseplatform.infrastructure.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
  private final CarRepository carRepository;

  public CarService(CarRepository carRepository) {
    this.carRepository = carRepository;
  }

  public List<Car> getAllCars() {
    return carRepository.findAll();
  }

  public Car getCarById(Long id) {
    return carRepository.findById(id)
        .orElseThrow(CarNotFoundException::new);  }

  public Car saveCar(Car car) {
    return carRepository.save(car);
  }

  public void deleteCar(Long id) {
    carRepository.deleteById(id);
  }
}
