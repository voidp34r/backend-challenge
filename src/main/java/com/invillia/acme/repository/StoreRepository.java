package com.invillia.acme.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

import com.invillia.acme.models.MyStore;

public interface StoreRepository extends CrudRepository<MyStore, Integer> {
    public Optional<MyStore> findById(Long id);
    public List<MyStore> findAll();
}
