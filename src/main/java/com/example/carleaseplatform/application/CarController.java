package com.example.carleaseplatform.application;

import com.example.carleaseplatform.domain.Car;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {
  private final CarService carService;

  public CarController(CarService carService) {
    this.carService = carService;
  }

  @GetMapping
   public List<Car> getAllCars() {
    return carService.getAllCars();
  }

  @GetMapping("/{id}")
  public Car getCarById(@PathVariable Long id) {
    return carService.getCarById(id);
  }

  @PostMapping
  public Car addCar(@RequestBody @Valid Car car) {
    return carService.saveCar(car);
  }

  @DeleteMapping("/{id}")
  public void deleteCar(@PathVariable Long id) {
    carService.deleteCar(id);
  }
}
