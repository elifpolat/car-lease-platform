package com.example.carleaseplatform.application.port.in;

public interface LeaseRateUsecase {

  double calculateLeaseRate(double mileage, int duration, double interestRate, double nettPrice);
}
