package com.example.carleaseplatform;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.carleaseplatform.adapter.out.Customer;
import com.example.carleaseplatform.application.CustomerService;
import com.example.carleaseplatform.domain.exception.CustomerNotFoundException;
import com.example.carleaseplatform.infrastructure.CustomerRepository;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

  @Mock
  private CustomerRepository customerRepository;

  @InjectMocks
  private CustomerService customerService;

  @Test
  public void testGetAllCustomers() {
    List<Customer> customers = List.of(
        new Customer(1L, "John Doe", "Main Street", "123", "12345", "New York", "johndoe@example.com", "+123456789"),
        new Customer(2L, "Jane Smith", "Second Street", "456", "54321", "Los Angeles", "janesmith@example.com", "+987654321")
    );
    when(customerRepository.findAll()).thenReturn(customers);

    List<Customer> result = customerService.getAllCustomers();

    assertEquals(2, result.size());
    assertEquals("John Doe", result.get(0).getName());
  }

  @Test
  public void testGetCustomerById() {
    Customer customer = new Customer(1L, "John Doe", "Main Street", "123", "12345", "New York", "johndoe@example.com", "+123456789");
    when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));

    Customer result = customerService.getCustomerById(1L);

    assertNotNull(result);
    assertEquals("John Doe", result.getName());
  }

  @Test
  public void testSaveCustomer() {
    Customer customer = new Customer(null, "Jane Doe", "Second Street", "456", "54321", "Los Angeles", "janedoe@example.com", "+987654321");
    when(customerRepository.save(customer)).thenReturn(new Customer(1L, "Jane Doe", "Second Street", "456", "54321", "Los Angeles", "janedoe@example.com", "+987654321"));

    Customer savedCustomer = customerService.saveCustomer(customer);

    assertNotNull(savedCustomer.getId());
    assertEquals("Jane Doe", savedCustomer.getName());
  }

  @Test
  public void testDeleteCustomer() {
    customerService.deleteCustomer(1L);

    verify(customerRepository, times(1)).deleteById(1L);
  }

  @Test
  public void testGetCustomerByIdNotFound() {
    when(customerRepository.findById(1L)).thenReturn(Optional.empty());

    assertThrows(CustomerNotFoundException.class, () -> customerService.getCustomerById(1L));
  }
}
