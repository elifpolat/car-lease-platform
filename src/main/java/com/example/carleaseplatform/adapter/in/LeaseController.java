package com.example.carleaseplatform.adapter.in;

import com.example.carleaseplatform.application.port.in.LeaseRateUsecase;
import com.example.carleaseplatform.infrastructure.configuration.InboundAdapter;
import com.example.carleaseplatform.model.CalculateLeaseRateUsingCarIdRequest;
import com.example.carleaseplatform.model.LeaseRateApiModel;
import com.example.carleaseplatform.model.LeaseRateResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Controller class responsible for handling lease-related operations.
 * This class provides endpoints to calculate lease rates based on input parameters
 * or using a car's ID to get nett price.
 */
@Slf4j
@InboundAdapter
@RestController
@RequestMapping("/api/lease")
public class LeaseController implements com.example.carleaseplatform.api.CarLeaseApi {

  private final LeaseRateUsecase leaseRateUsecase;

  public LeaseController(LeaseRateUsecase leaseRateUsecase) {
    this.leaseRateUsecase = leaseRateUsecase;
  }

  /**
   * Calculates the lease rate based on the provided input parameters.
   *
   * @param leaseRateApiModel the lease rate calculation input containing mileage, duration,
   *                          interest rate, and nett price
   * @return a {@link ResponseEntity} containing the calculated lease rate in the response body
   */
  @Override
  @PostMapping("/calculate")
  public ResponseEntity<LeaseRateResponse> calculateLeaseRate(@Valid @RequestBody LeaseRateApiModel leaseRateApiModel) {
    Double calculatedRate = leaseRateUsecase.calculateLeaseRate(
        leaseRateApiModel.getMileage(),
        leaseRateApiModel.getDuration(),
        leaseRateApiModel.getInterestRate(),
        leaseRateApiModel.getNettPrice()
    );
    LeaseRateResponse response = new LeaseRateResponse().leaseRate(calculatedRate);

    return ResponseEntity.ok(response);
  }

  /**
   * Calculates the lease rate using a car ID and other input parameters.
   * The car's nett price is fetched using the car ID.
   *
   * @param request the request containing the lease rate calculation input and the car ID
   * @return a {@link ResponseEntity} containing the calculated lease rate in the response body
   */
  @Override
  @PostMapping("/calculate-with-car-id")
  public ResponseEntity<LeaseRateResponse> calculateLeaseRateUsingCarId(
      @Valid @RequestBody CalculateLeaseRateUsingCarIdRequest request) {
    Double calculatedRate = leaseRateUsecase.calculateLeaseRateWithCarId(
        request.getLeaseRateRequest(), request.getCarId()
    );
    LeaseRateResponse response = new LeaseRateResponse().leaseRate(calculatedRate);
    return ResponseEntity.ok(response);
  }

}
