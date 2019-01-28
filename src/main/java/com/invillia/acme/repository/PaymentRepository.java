package com.invillia.acme.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

import com.invillia.acme.models.MyPayment;

public interface PaymentRepository extends CrudRepository<MyPayment, Integer> {
    public Optional<MyPayment> findById(Long id);
    public List<MyPayment> findAll();
}
