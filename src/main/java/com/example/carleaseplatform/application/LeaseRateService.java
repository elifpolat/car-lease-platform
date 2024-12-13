package com.example.carleaseplatform.application;

import com.example.carleaseplatform.application.port.in.LeaseRateUsecase;
import java.math.BigDecimal;
import java.math.RoundingMode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LeaseRateService implements LeaseRateUsecase {

  @Override
  public double calculateLeaseRate(double mileage, int duration, double interestRate, double nettPrice) {
    double leaseRate = ((mileage/12 * duration) / nettPrice)
        + (((interestRate / 100) * nettPrice) / 12);

    return BigDecimal.valueOf(leaseRate)
        .setScale(2, RoundingMode.HALF_UP)
        .doubleValue();
  }
}
