package com.example.carleaseplatform.application;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.springframework.stereotype.Service;

@Service
public class LeaseRateService {

  public double calculateLeaseRate(double mileage, int duration, double interestRate, double nettPrice) {
    double leaseRate = ((mileage/12 * duration) / nettPrice)
        + (((interestRate / 100) * nettPrice) / 12);

    return BigDecimal.valueOf(leaseRate)
        .setScale(2, RoundingMode.HALF_UP)
        .doubleValue();
  }
}
