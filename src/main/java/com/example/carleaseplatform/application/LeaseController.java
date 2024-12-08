package com.example.carleaseplatform.application;

import com.example.carleaseplatform.domain.Lease;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/lease")
public class LeaseController {

  private final LeaseRateService leaseRateService;

  public LeaseController(LeaseRateService leaseRateService) {
    this.leaseRateService = leaseRateService;
  }

  @PostMapping("/calculate")
  public double calculateLeaseRate(@RequestBody Lease lease) {
    return leaseRateService.calculateLeaseRate(
        lease.getMileage(),
        lease.getDuration(),
        lease.getInterestRate(),
        lease.getNettPrice()
    );
  }
}
