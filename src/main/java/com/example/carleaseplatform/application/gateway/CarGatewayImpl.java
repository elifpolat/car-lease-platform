package com.example.carleaseplatform.application.gateway;

import com.example.carleaseplatform.api.CarApi;
import com.example.carleaseplatform.application.port.in.CarGateway;
import com.example.carleaseplatform.model.CarApiModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CarGatewayImpl implements CarGateway {

  private final CarApi carApi;

  public CarGatewayImpl(CarApi carApi) {
    this.carApi = carApi;
  }

  @Override
  public ResponseEntity<CarApiModel> getCarById(Long carId) {
    return carApi.getCarById(carId);
  }
}
