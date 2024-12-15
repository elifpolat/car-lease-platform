package com.example.carleaseplatform;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.carleaseplatform.application.port.in.CarGateway;
import com.example.carleaseplatform.model.CarApiModel;
import com.example.carleaseplatform.model.LeaseRateApiModel;
import com.example.carleaseplatform.application.LeaseRateService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class LeaseRateServiceTest {

  @Mock
  private CarGateway carGateway;

  @InjectMocks
  private LeaseRateService leaseRateService;

  @Test
  public void testCalculateLeaseRate() {
    double leaseRate = leaseRateService.calculateLeaseRate(1200, 60, 4, 60000);

    assertEquals(200.1, leaseRate, 0.01);
  }

  @Test
  public void testCalculateLeaseRateWithCarId() {
    CarApiModel car = new CarApiModel();
    car.setNettPrice(60000.0);

    when(carGateway.getCarById(1L)).thenReturn(ResponseEntity.ok(car));

    LeaseRateApiModel leaseRateRequest = new LeaseRateApiModel();
    leaseRateRequest.setMileage(1200.00);
    leaseRateRequest.setDuration(60);
    leaseRateRequest.setInterestRate(4.00);

    double leaseRate = leaseRateService.calculateLeaseRateWithCarId(leaseRateRequest, 1L);

    assertEquals(200.1, leaseRate, 0.01);
  }

  @Test
  public void testCalculateLeaseRateWithCarIdNotFound() {
    when(carGateway.getCarById(1L)).thenReturn(ResponseEntity.notFound().build());

    LeaseRateApiModel leaseRateRequest = new LeaseRateApiModel();
    leaseRateRequest.setMileage(1200.00);
    leaseRateRequest.setDuration(60);
    leaseRateRequest.setInterestRate(4.00);

    assertThrows(IllegalArgumentException.class, () -> leaseRateService.calculateLeaseRateWithCarId(leaseRateRequest, 1L));
  }

}
