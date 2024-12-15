package com.example.carleaseplatform.application;

import com.example.carleaseplatform.application.port.in.CarUsecase;
import com.example.carleaseplatform.adapter.out.Car;
import com.example.carleaseplatform.domain.exception.CarNotFoundException;
import com.example.carleaseplatform.infrastructure.CarRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CarService implements CarUsecase {

  private final CarRepository carRepository;

  public CarService(CarRepository carRepository) {
    this.carRepository = carRepository;
  }

  @Override
  public List<Car> getAllCars() {
    return carRepository.findAll();
  }

  @Override
  public Car getCarById(Long id) {
    return carRepository.findById(id)
        .orElseThrow(CarNotFoundException::new);
  }

  @Override
  public Car saveCar(Car car) {
    return carRepository.save(car);
  }

  @Override
  public void deleteCar(Long id) {
    carRepository.deleteById(id);
  }
}
