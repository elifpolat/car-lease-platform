package com.example.carleaseplatform.adapter.in;

import com.example.carleaseplatform.adapter.in.mapper.CarMapper;
import com.example.carleaseplatform.api.CarApi;
import com.example.carleaseplatform.application.port.in.CarUsecase;
import com.example.carleaseplatform.infrastructure.configuration.InboundAdapter;
import com.example.carleaseplatform.model.CarApiModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@InboundAdapter
@RestController
@RequestMapping("/api/cars")
public class CarController implements CarApi {

  private final CarUsecase carUsecase;
  private final CarMapper carMapper;

  public CarController(CarUsecase carUsecase, CarMapper carMapper) {
    this.carUsecase = carUsecase;
    this.carMapper = carMapper;
  }

  @Override
  @PostMapping
  public ResponseEntity<CarApiModel> addCar(@RequestBody CarApiModel car) {
    var savedCar = carUsecase.saveCar(carMapper.toDomain(car));
    return ResponseEntity.ok(carMapper.toApi(savedCar));
  }
  @Override
  @PutMapping("/{id}")
  public ResponseEntity<CarApiModel> updateCarById(@PathVariable Long id, @RequestBody CarApiModel car) {
    var carDomain = carMapper.toDomain(car);
    carDomain.setId(id);
    var updated = carUsecase.saveCar(carDomain);
    return ResponseEntity.ok(carMapper.toApi(updated));
  }

  @Override
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteCarById(@PathVariable("id") Long id) {
    carUsecase.deleteCar(id);
    return ResponseEntity.noContent().build();
  }

  @Override
  @GetMapping
  public ResponseEntity<List<CarApiModel>> getAllCars() {
    var cars = carUsecase.getAllCars().stream()
        .map(carMapper::toApi)
        .toList();
    return ResponseEntity.ok(cars);
  }

  @Override
  @GetMapping("/{id}")
  public ResponseEntity<CarApiModel> getCarById(@PathVariable("id") Long id) {
    var car = carUsecase.getCarById(id);
    return ResponseEntity.ok(carMapper.toApi(car));
  }
}
