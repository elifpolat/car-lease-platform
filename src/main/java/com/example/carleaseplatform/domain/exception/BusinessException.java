package com.example.carleaseplatform.domain.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class BusinessException extends RuntimeException {

  private final String error;
  private final HttpStatus status;

  protected BusinessException(String error, HttpStatus status, String message) {
    super(message);
    this.error = error;
    this.status = status;
  }

  protected BusinessException(String error, HttpStatus status, String message, Throwable t) {
    super(message, t);
    this.error = error;
    this.status = status;
  }
}
