package com.example.carleaseplatform.adapter.in.mapper;

import com.example.carleaseplatform.adapter.out.Customer;
import org.springframework.stereotype.Component;
import com.example.carleaseplatform.model.CustomerApiModel;

@Component
public class CustomerMapper {

  public Customer toDomain(CustomerApiModel customerApiModel) {
    if (customerApiModel == null) {
      return null;
    }

    Customer customer = new Customer();
    customer.setId(customerApiModel.getId());
    customer.setName(customerApiModel.getName());
    customer.setStreet(customerApiModel.getStreet());
    customer.setHouseNumber(customerApiModel.getHouseNumber());
    customer.setZipCode(customerApiModel.getZipCode());
    customer.setPlace(customerApiModel.getPlace());
    customer.setEmail(customerApiModel.getEmail());
    customer.setPhoneNumber(customerApiModel.getPhoneNumber());

    return customer;
  }

  public CustomerApiModel toApi(Customer customer) {
    if (customer == null) {
      return null;
    }

    CustomerApiModel customerApiModel = new CustomerApiModel();
    customerApiModel.setId(customer.getId());
    customerApiModel.setName(customer.getName());
    customerApiModel.setStreet(customer.getStreet());
    customerApiModel.setHouseNumber(customer.getHouseNumber());
    customerApiModel.setZipCode(customer.getZipCode());
    customerApiModel.setPlace(customer.getPlace());
    customerApiModel.setEmail(customer.getEmail());
    customerApiModel.setPhoneNumber(customer.getPhoneNumber());

    return customerApiModel;
  }
}