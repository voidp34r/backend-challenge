package com.invillia.acme.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

import com.invillia.acme.models.MyOrderItem;

public interface OrderItemRepository extends CrudRepository<MyOrderItem, Integer> {
    public Optional<MyOrderItem> findById(Long id);
    public List<MyOrderItem> findAll();
}
