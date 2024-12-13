package com.example.carleaseplatform.application.port.in;

import com.example.carleaseplatform.domain.Customer;
import java.util.List;

public interface CustomerUsecase {

  List<Customer> getAllCustomers();

  Customer getCustomerById(Long id);

  Customer saveCustomer(Customer customer);

  void deleteCustomer(Long id);
}
