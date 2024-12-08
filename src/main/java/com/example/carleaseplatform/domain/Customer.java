package com.example.carleaseplatform.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String street;
  private String houseNumber;
  private String zipCode;
  private String place;
  private String email;
  private String phoneNumber;
}
