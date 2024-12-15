package com.example.carleaseplatform.application.port.in;

import com.example.carleaseplatform.model.CarApiModel;
import org.springframework.http.ResponseEntity;
public interface CarGateway {
  ResponseEntity<CarApiModel> getCarById(Long carId);
}