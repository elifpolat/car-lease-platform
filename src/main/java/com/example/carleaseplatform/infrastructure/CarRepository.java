package com.example.carleaseplatform.infrastructure;

import com.example.carleaseplatform.adapter.out.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
