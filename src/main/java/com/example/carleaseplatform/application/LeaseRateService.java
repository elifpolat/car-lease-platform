package com.example.carleaseplatform.application;

import com.example.carleaseplatform.api.CarApi;
import com.example.carleaseplatform.application.port.in.CarGateway;
import com.example.carleaseplatform.application.port.in.LeaseRateUsecase;
import com.example.carleaseplatform.model.LeaseRateApiModel;
import java.math.BigDecimal;
import java.math.RoundingMode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class LeaseRateService implements LeaseRateUsecase {

  private final CarGateway carGateway;

  public LeaseRateService(CarGateway carGateway) {
    this.carGateway = carGateway;
  }

  @Override
  @Transactional
  public double calculateLeaseRate(double mileage, int duration, double interestRate, double nettPrice) {
    return baseLeaseCalculation(mileage, duration, interestRate, nettPrice);
  }

  @Override
  @Transactional
  public double calculateLeaseRateWithCarId(LeaseRateApiModel leaseRateRequest, Long carId) {
    var response = carGateway.getCarById(carId);

    if (!response.getStatusCode().is2xxSuccessful() || response.getBody() == null) {
      throw new IllegalArgumentException("Failed to fetch car details for ID: " + carId);
    }

    var car = response.getBody();
    return baseLeaseCalculation(
        leaseRateRequest.getMileage(),
        leaseRateRequest.getDuration(),
        leaseRateRequest.getInterestRate(),
        car.getNettPrice()
    );
  }

  protected double baseLeaseCalculation(double mileage, int duration, double interestRate, double nettPrice) {
    double leaseRate = ((mileage / 12 * duration) / nettPrice)
        + (((interestRate / 100) * nettPrice) / 12);

    return BigDecimal.valueOf(leaseRate)
        .setScale(2, RoundingMode.HALF_UP)
        .doubleValue();
  }
}
