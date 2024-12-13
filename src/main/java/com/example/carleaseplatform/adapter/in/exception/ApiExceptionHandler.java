package com.example.carleaseplatform.adapter.in.exception;

import com.example.carleaseplatform.domain.exception.BusinessException;
import com.example.carleaseplatform.model.ApiError;
import com.example.carleaseplatform.model.ApiError.ErrorEnum;
import com.example.carleaseplatform.model.ApiErrors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(AccessDeniedException.class)
  public ResponseEntity<?> handleAccessDenied(Exception ex, WebRequest request) {
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
  }

  @ExceptionHandler(BusinessException.class)
  public ResponseEntity<?> handleBusinessException(BusinessException ex) {
    var apiError = new ApiError()
        .error(ErrorEnum.valueOf(ex.getError()))
        .errorDescription(ex.getMessage())
        .statusCode(ex.getStatus().value());
    return ResponseEntity.status(ex.getStatus().value()).headers(new HttpHeaders()).body(new ApiErrors().addErrorsItem(apiError));
  }
}
