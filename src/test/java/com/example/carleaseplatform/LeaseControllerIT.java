package com.example.carleaseplatform;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class LeaseControllerIT {

  @Autowired
  private MockMvc mockMvc;
  @Test
  @WithMockUser(username = "testuser", roles = "USER")
  public void testCalculateLeaseRate() throws Exception {
    String leaseDtoJson = """
        {
            "mileage": 1200,
            "duration": 60,
            "interestRate": 4,
            "nettPrice": 60000
        }
        """;

    mockMvc.perform(post("/api/lease/calculate")
            .contentType(MediaType.APPLICATION_JSON)
            .content(leaseDtoJson))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.leaseRate").value(200.1));
  }

  @Test
  public void testCalculateLeaseRateUnauthorized() throws Exception {
    String leaseDtoJson = """
        {
            "mileage": 1200,
            "duration": 60,
            "interestRate": 4,
            "nettPrice": 60000
        }
        """;

    mockMvc.perform(post("/api/lease/calculate")
            .contentType(MediaType.APPLICATION_JSON)
            .content(leaseDtoJson))
        .andExpect(status().isUnauthorized());
  }
}

