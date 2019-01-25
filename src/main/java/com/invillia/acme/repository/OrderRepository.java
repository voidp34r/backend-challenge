package com.invillia.acme.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

import com.invillia.acme.models.Order;

public interface OrderRepository extends CrudRepository<Order, Integer> {
    public Optional<Order> findById(Long id);
    public List<Order> findByStatus(String status);
    public List<Order> findAll();
}
