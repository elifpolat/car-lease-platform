package com.example.carleaseplatform.adapter.out;

import lombok.Data;

@Data
public class LeaseRateModel {
  private double mileage;
  private int duration;
  private double interestRate;
  private double nettPrice;
}