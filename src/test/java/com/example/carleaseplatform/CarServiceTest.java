package com.example.carleaseplatform;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.carleaseplatform.adapter.out.Car;
import com.example.carleaseplatform.application.CarService;
import com.example.carleaseplatform.domain.exception.CarNotFoundException;
import com.example.carleaseplatform.infrastructure.CarRepository;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CarServiceTest {

  @Mock
  private CarRepository carRepository;

  @InjectMocks
  private CarService carService;

  @Test
  public void testGetAllCars() {
    List<Car> cars = List.of(
        new Car(1L, "Tesla", "Model S", "2023", 4, 0, 80000.0, 75000.0),
        new Car(2L, "BMW", "i3", "2022", 5, 50, 50000.0, 45000.0)
    );
    when(carRepository.findAll()).thenReturn(cars);

    List<Car> result = carService.getAllCars();

    assertEquals(2, result.size());
    assertEquals("Tesla", result.get(0).getBrand());
  }

  @Test
  public void testGetCarById() {
    Car car = new Car(1L, "Tesla", "Model S", "2023", 4, 0, 80000.0, 75000.0);
    when(carRepository.findById(1L)).thenReturn(Optional.of(car));

    Car result = carService.getCarById(1L);

    assertNotNull(result);
    assertEquals("Tesla", result.getBrand());
  }

  @Test
  public void testSaveCar() {
    Car car = new Car(null, "Tesla", "Model 3", "2023", 4, 0, 60000.0, 55000.0);
    when(carRepository.save(car)).thenReturn(new Car(1L, "Tesla", "Model 3", "2023", 4, 0, 60000.0, 55000.0));

    Car savedCar = carService.saveCar(car);

    assertNotNull(savedCar.getId());
    assertEquals("Tesla", savedCar.getBrand());
  }

  @Test
  public void testDeleteCar() {
    carService.deleteCar(1L);

    verify(carRepository, times(1)).deleteById(1L);
  }

  @Test
  public void testGetCarByIdNotFound() {
    when(carRepository.findById(1L)).thenReturn(Optional.empty());

    assertThrows(CarNotFoundException.class, () -> carService.getCarById(1L));
  }
}
