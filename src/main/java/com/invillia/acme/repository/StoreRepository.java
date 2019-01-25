package com.invillia.acme.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

import com.invillia.acme.models.Store;

public interface StoreRepository extends CrudRepository<Store, Integer> {
    public Optional<Store> findById(Long id);
    public List<Store> findByStatus(String status);
    public List<Store> findAll();
}
