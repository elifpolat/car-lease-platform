package com.example.carleaseplatform.adapter.in.mapper;

import com.example.carleaseplatform.adapter.out.LeaseRateModel;
import com.example.carleaseplatform.model.LeaseRateApiModel;
import org.springframework.stereotype.Component;

@Component
public class LeaseRateMapper {

  public LeaseRateModel toDomain(LeaseRateApiModel leaseApiModel) {
    if (leaseApiModel == null) {
      return null;
    }

    LeaseRateModel lease = new LeaseRateModel();
    lease.setMileage(leaseApiModel.getMileage());
    lease.setDuration(leaseApiModel.getDuration());
    lease.setInterestRate(leaseApiModel.getInterestRate());
    lease.setNettPrice(leaseApiModel.getNettPrice());

    return lease;
  }

  public LeaseRateApiModel toApi(LeaseRateModel lease) {
    if (lease == null) {
      return null;
    }

    LeaseRateApiModel leaseApiModel = new LeaseRateApiModel();
    leaseApiModel.setMileage(lease.getMileage());
    leaseApiModel.setDuration(lease.getDuration());
    leaseApiModel.setInterestRate(lease.getInterestRate());
    leaseApiModel.setNettPrice(lease.getNettPrice());

    return leaseApiModel;
  }
}
