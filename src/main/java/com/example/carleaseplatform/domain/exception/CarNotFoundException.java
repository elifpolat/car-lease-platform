package com.example.carleaseplatform.domain.exception;

import org.springframework.http.HttpStatus;

public class CarNotFoundException extends BusinessException {

  public CarNotFoundException() {
    super("CAR_NOT_FOUND", HttpStatus.NOT_FOUND, "Car not found");
  }
}
