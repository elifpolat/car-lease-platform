package com.example.carleaseplatform.infrastructure;

import com.example.carleaseplatform.adapter.out.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
