package com.example.carleaseplatform.application;

import com.example.carleaseplatform.domain.Customer;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

  private final CustomerService customerService;

  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @GetMapping
  public List<Customer> getAllCustomers() {
    System.out.println("Get all customers called");
    return customerService.getAllCustomers();
  }

  @GetMapping("/{id}")
  public Customer getCustomerById(@PathVariable Long id) {
    return customerService.getCustomerById(id);
  }

  @PostMapping
  public Customer addCustomer(@RequestBody @Valid Customer customer) {
    System.out.println("Create customer called");
    return customerService.saveCustomer(customer);
  }

  @DeleteMapping("/{id}")
  public void deleteCustomer(@PathVariable Long id) {
    customerService.deleteCustomer(id);
  }
}
