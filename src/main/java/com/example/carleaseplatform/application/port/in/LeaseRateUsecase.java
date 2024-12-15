package com.example.carleaseplatform.application.port.in;

public interface LeaseRateUsecase {

  double calculateLeaseRate(double mileage, int duration, double interestRate, double nettPrice);
  double calculateLeaseRateWithCarId(com.example.carleaseplatform.model.LeaseRateApiModel leaseRateRequest, Long carId);

}
