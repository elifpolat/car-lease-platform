package com.example.carleaseplatform.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Car {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "Brand is mandatory")
  private String brand;

  @NotBlank(message = "Model is mandatory")
  private String model;

  @NotBlank(message = "Version is mandatory")
  private String version;

  @Min(value = 2, message = "Number of doors must be at least 2")
  @Max(value = 5, message = "Number of doors cannot exceed 5")
  private int numberOfDoors;

  @Min(value = 0, message = "CO2 emission must be non-negative")
  private int co2Emission;

  @DecimalMin(value = "0.0", inclusive = false, message = "Gross price must be greater than 0")
  private double grossPrice;

  @DecimalMin(value = "0.0", inclusive = false, message = "Nett price must be greater than 0")
  private double nettPrice;

}