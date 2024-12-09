package com.example.carleaseplatform.domain.exception;

import org.springframework.http.HttpStatus;

public class CustomerNotFoundException extends BusinessException {

  public CustomerNotFoundException() {
    super("CUSTOMER_NOT_FOUND", HttpStatus.NOT_FOUND, "Customer not found");
  }
}
