package com.invillia.acme.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

import com.invillia.acme.models.MyOrder;

public interface OrderRepository extends CrudRepository<MyOrder, Integer> {
    public Optional<MyOrder> findById(Long id);
    public List<MyOrder> findAll();
}
