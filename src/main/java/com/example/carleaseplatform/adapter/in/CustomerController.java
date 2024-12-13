package com.example.carleaseplatform.adapter.in;

import com.example.carleaseplatform.adapter.in.converter.CustomerDtoConverter;
import com.example.carleaseplatform.adapter.in.mapper.CustomerMapper;
import com.example.carleaseplatform.application.port.in.CustomerUsecase;
import com.example.carleaseplatform.infrastructure.configuration.InboundAdapter;
import com.example.carleaseplatform.model.CustomerApiModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@InboundAdapter
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customers")
public class CustomerController implements com.example.carleaseplatform.api.CustomerApi {

  private final CustomerUsecase customerUsecase;
  private final CustomerMapper customerMapper;
  private final CustomerDtoConverter customerDtoConverter;

  @Override
  @PostMapping
  public ResponseEntity<CustomerApiModel> addCustomer(@RequestBody CustomerApiModel customer) {
    log.info("Adding a new customer: {}", customer);
    var savedCustomer = customerUsecase.saveCustomer(customerMapper.toDomain(customer));
    var customerApiModel = customerDtoConverter.apply(savedCustomer);
    return ResponseEntity.ok(customerApiModel);
  }

  @Override
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteCustomerById(@PathVariable Long id) {
    log.info("Deleting customer with ID: {}", id);
    customerUsecase.deleteCustomer(id);
    return ResponseEntity.noContent().build();
  }

  @Override
  @GetMapping
  public ResponseEntity<List<CustomerApiModel>> getAllCustomers() {
    log.info("Fetching all customers");
    var customers = customerUsecase.getAllCustomers().stream()
        .map(customerDtoConverter)
        .collect(Collectors.toList());
    return ResponseEntity.ok(customers);
  }

  @Override
  @GetMapping("/{id}")
  public ResponseEntity<CustomerApiModel> getCustomerById(@PathVariable Long id) {
    log.info("Fetching customer with ID: {}", id);
    var customer = customerDtoConverter.apply(customerUsecase.getCustomerById(id));
    return ResponseEntity.ok(customer);
  }
}
