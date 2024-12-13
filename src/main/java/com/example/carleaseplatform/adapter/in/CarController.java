package com.example.carleaseplatform.adapter.in;

import com.example.carleaseplatform.adapter.in.converter.CarDtoConverter;
import com.example.carleaseplatform.adapter.in.mapper.CarMapper;
import com.example.carleaseplatform.application.port.in.CarUsecase;
import com.example.carleaseplatform.infrastructure.configuration.InboundAdapter;
import com.example.carleaseplatform.model.CarApiModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@InboundAdapter
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cars")
public class CarController implements com.example.carleaseplatform.api.CarApi {

  private final CarUsecase carUsecase;
  private final CarMapper carMapper;
  private final CarDtoConverter carDtoConverter;

  @Override
  public ResponseEntity<CarApiModel> addCar(@RequestBody CarApiModel car) {
    log.info("Adding a new car: {}", car);
    var savedCar = carUsecase.saveCar(carMapper.toDomain(car));
    return ResponseEntity.ok(carDtoConverter.apply(savedCar));
  }

  @Override
  public ResponseEntity<Void> deleteCarById(@PathVariable Long id) {
    log.info("Deleting car with ID: {}", id);
    carUsecase.deleteCar(id);
    return ResponseEntity.noContent().build();
  }

  @Override
  @GetMapping
  public ResponseEntity<List<CarApiModel>> getAllCars() {
    log.info("Fetching all cars");
    var cars = carUsecase.getAllCars().stream()
        .map(carDtoConverter)
        .toList();
    return ResponseEntity.ok(cars);
  }

  @Override
  public ResponseEntity<CarApiModel> getCarById(@PathVariable Long id) {
    log.info("Fetching car with ID: {}", id);
    var car = carUsecase.getCarById(id);
    return ResponseEntity.ok(carDtoConverter.apply(car));
  }
}
