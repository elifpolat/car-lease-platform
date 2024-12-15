package com.example.carleaseplatform;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class CarControllerIT {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @Test
  @WithMockUser(username = "test", roles = {"USER"})
  public void testAddCar() throws Exception {
    com.example.carleaseplatform.model.CarApiModel car = new com.example.carleaseplatform.model.CarApiModel();
    car.setBrand("Tesla");
    car.setModel("Model S");
    car.setVersion("2023");
    car.setNumberOfDoors(4);
    car.setCo2Emission(0);
    car.setGrossPrice(80000.00);
    car.setNettPrice(75000.00);

    mockMvc.perform(post("/api/cars")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(car)))
        .andExpect(status().isOk()) // Validate HTTP 200 response
        .andExpect(jsonPath("$.brand").value("Tesla"))
        .andExpect(jsonPath("$.model").value("Model S"));
  }


  @Test
  @WithMockUser(username = "test", roles = {"USER"})
  public void testDeleteCarById() throws Exception {
    mockMvc.perform(delete("/api/cars/{id}", 1L)
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isNoContent());
  }
}