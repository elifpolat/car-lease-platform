package com.example.carleaseplatform.adapter.in.converter;

import com.example.carleaseplatform.domain.Customer;
import com.example.carleaseplatform.model.CustomerApiModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerDtoConverter implements Converter<Customer, CustomerApiModel> {

  @Override
  public CustomerApiModel apply(Customer customer) {
    if (customer == null) {
      throw new IllegalArgumentException("customer must not be null when converting to api dto!");
    }
    return new CustomerApiModel()
        .id(customer.getId())
        .email(customer.getEmail())
        .name(customer.getName())
        .houseNumber(customer.getHouseNumber())
        .place(customer.getPlace())
        .street(customer.getStreet())
        .phoneNumber(customer.getPhoneNumber())
        .zipCode(customer.getZipCode());
  }
}
