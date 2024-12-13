package com.example.carleaseplatform.adapter.in;

import com.example.carleaseplatform.application.port.in.LeaseRateUsecase;
import com.example.carleaseplatform.infrastructure.configuration.InboundAdapter;
import com.example.carleaseplatform.model.LeaseRateApiModel;
import com.example.carleaseplatform.model.LeaseRateResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@InboundAdapter
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/lease")
public class LeaseController implements com.example.carleaseplatform.api.CarLeaseApi {

  private final LeaseRateUsecase leaseRateUsecase;

  @Override
  public ResponseEntity<LeaseRateResponse> calculateLeaseRate(@Valid @RequestBody LeaseRateApiModel leaseRateApiModel) {
    log.info("Calculating lease rate with input: {}", leaseRateApiModel);
    Double calculatedRate = leaseRateUsecase.calculateLeaseRate(
        leaseRateApiModel.getMileage(),
        leaseRateApiModel.getDuration(),
        leaseRateApiModel.getInterestRate(),
        leaseRateApiModel.getNettPrice()
    );
    LeaseRateResponse response = new LeaseRateResponse().leaseRate(calculatedRate);

    log.info("Calculated lease rate: {}", response.getLeaseRate());

    return ResponseEntity.ok(response);
  }
}
