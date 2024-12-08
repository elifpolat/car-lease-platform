package com.example.carleaseplatform.application;

import com.example.carleaseplatform.domain.Customer;
import com.example.carleaseplatform.infrastructure.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
  private final CustomerRepository customerRepository;

  public CustomerService(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  public List<Customer> getAllCustomers() {
    return customerRepository.findAll();
  }

  public Customer getCustomerById(Long id) {
    return customerRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Customer not found"));
  }

  public Customer saveCustomer(Customer customer) {
    return customerRepository.save(customer);
  }

  public void deleteCustomer(Long id) {
    customerRepository.deleteById(id);
  }
}
