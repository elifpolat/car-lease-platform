package com.example.carleaseplatform.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Car {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String make;
  private String model;
  private String version;
  private int numberOfDoors;
  private int co2Emission;
  private double grossPrice;
  private double netPrice;
}
