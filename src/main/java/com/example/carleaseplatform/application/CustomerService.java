package com.example.carleaseplatform.application;

import com.example.carleaseplatform.application.port.in.CustomerUsecase;
import com.example.carleaseplatform.adapter.out.Customer;
import com.example.carleaseplatform.domain.exception.CustomerNotFoundException;
import com.example.carleaseplatform.infrastructure.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerService implements CustomerUsecase {

  private final CustomerRepository customerRepository;

  @Override
  public List<Customer> getAllCustomers() {
    return customerRepository.findAll();
  }

  @Override
  public Customer getCustomerById(Long id) {
    return customerRepository.findById(id)
        .orElseThrow(CustomerNotFoundException::new);
  }

  @Override
  public Customer saveCustomer(Customer customer) {
    return customerRepository.save(customer);
  }

  @Override
  public void deleteCustomer(Long id) {
    customerRepository.deleteById(id);
  }
}
