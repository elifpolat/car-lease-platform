package com.example.carleaseplatform;

import com.example.carleaseplatform.model.CustomerApiModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class CustomerControllerIT {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;


  @Test
  @WithMockUser(username = "test", roles = {"USER"})
  public void testAddCustomer() throws Exception {
    CustomerApiModel customer = new CustomerApiModel();
    customer.setName("John Doe");
    customer.setStreet("Main Street");
    customer.setHouseNumber("123");
    customer.setZipCode("12345");
    customer.setPlace("New York");
    customer.setEmail("johndoe@example.com");
    customer.setPhoneNumber("+123456789");

    mockMvc.perform(post("/api/customers")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(customer)))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id", notNullValue()))
        .andExpect(jsonPath("$.name", is("John Doe")));
  }


  @Test
  @WithMockUser(username = "test", roles = {"USER"})
  public void testGetCustomerById() throws Exception {
    CustomerApiModel customer = new CustomerApiModel();
    customer.setName("Jane Doe");
    customer.setStreet("Second Street");
    customer.setHouseNumber("456");
    customer.setZipCode("54321");
    customer.setPlace("Los Angeles");
    customer.setEmail("janedoe@example.com");
    customer.setPhoneNumber("+987654321");

    String response = mockMvc.perform(post("/api/customers")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(customer)))
        .andExpect(status().isOk())
        .andReturn().getResponse().getContentAsString();

    CustomerApiModel savedCustomer = objectMapper.readValue(response, CustomerApiModel.class);

    mockMvc.perform(get("/api/customers/{id}", savedCustomer.getId())
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id", is(savedCustomer.getId().intValue())))
        .andExpect(jsonPath("$.name", is("Jane Doe")));
  }

}