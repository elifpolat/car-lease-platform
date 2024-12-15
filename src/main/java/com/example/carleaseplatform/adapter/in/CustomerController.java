package com.example.carleaseplatform.adapter.in;

import com.example.carleaseplatform.adapter.in.mapper.CustomerMapper;
import com.example.carleaseplatform.application.port.in.CustomerUsecase;
import com.example.carleaseplatform.infrastructure.configuration.InboundAdapter;
import com.example.carleaseplatform.model.CustomerApiModel;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@InboundAdapter
@RestController
@RequestMapping("/api/customers")
public class CustomerController implements com.example.carleaseplatform.api.CustomerApi {

  private final CustomerUsecase customerUsecase;
  private final CustomerMapper customerMapper;

  public CustomerController(CustomerUsecase customerUsecase, CustomerMapper customerMapper) {
    this.customerUsecase = customerUsecase;
    this.customerMapper = customerMapper;
  }

  @Override
  @PostMapping
  public ResponseEntity<CustomerApiModel> addCustomer(@RequestBody @Valid CustomerApiModel customer) {
    var savedCustomer = customerUsecase.saveCustomer(customerMapper.toDomain(customer));
    var customerApiModel = customerMapper.toApi(savedCustomer);
    return ResponseEntity.ok(customerApiModel);
  }

  @Override
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteCustomerById(@PathVariable Long id) {
    customerUsecase.deleteCustomer(id);
    return ResponseEntity.noContent().build();
  }

  @Override
  @GetMapping
  public ResponseEntity<List<CustomerApiModel>> getAllCustomers() {
    var customers = customerUsecase.getAllCustomers().stream()
        .map(customerMapper::toApi)
        .collect(Collectors.toList());
    return ResponseEntity.ok(customers);
  }

  @Override
  @GetMapping("/{id}")
  public ResponseEntity<CustomerApiModel> getCustomerById(@PathVariable Long id) {
    var customer = customerMapper.toApi(customerUsecase.getCustomerById(id));
    return ResponseEntity.ok(customer);
  }
}
