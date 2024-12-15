package com.example.carleaseplatform.adapter.out;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Data
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "Name is mandatory")
  private String name;

  @NotBlank(message = "Street is mandatory")
  private String street;

  @NotBlank(message = "House number is mandatory")
  private String houseNumber;

  @NotBlank(message = "Zip code is mandatory")
  @Pattern(regexp = "\\d{5}", message = "Zip code must be 5 digits")
  private String zipCode;

  @NotBlank(message = "Place is mandatory")
  private String place;

  @Email(message = "Email should be valid")
  private String email;

  @NotBlank(message = "Phone number is mandatory")
  @Pattern(regexp = "\\+?\\d+", message = "Phone number should be valid")
  private String phoneNumber;

  public Customer(Long id, String name, String street, String houseNumber, String zipCode, String place, String email, String phoneNumber) {
    this.id = id;
    this.name = name;
    this.street = street;
    this.houseNumber = houseNumber;
    this.zipCode = zipCode;
    this.place = place;
    this.email = email;
    this.phoneNumber = phoneNumber;
  }

  public Customer() {
  }
}