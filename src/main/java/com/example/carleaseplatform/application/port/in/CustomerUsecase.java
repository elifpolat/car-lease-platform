package com.example.carleaseplatform.application.port.in;

import com.example.carleaseplatform.adapter.out.Customer;
import java.util.List;

public interface CustomerUsecase {

  List<Customer> getAllCustomers();

  Customer getCustomerById(Long id);

  Customer saveCustomer(Customer customer);

  void deleteCustomer(Long id);
}
