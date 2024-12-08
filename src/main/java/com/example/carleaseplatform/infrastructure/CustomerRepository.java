package com.example.carleaseplatform.infrastructure;

import com.example.carleaseplatform.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
