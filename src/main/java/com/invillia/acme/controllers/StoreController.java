package com.invillia.acme.controllers;

import java.net.URI;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import com.invillia.acme.models.Store;
import com.invillia.acme.repository.StoreRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@PreAuthorize("hasAnyRole('ADMIN','USER')")
@RequestMapping(value = "/api")
public class StoreController {

    @Autowired
    private StoreRepository storeRepository;

    @Secured({ "ROLE_ADMIN", "ROLE_USER" })
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/stores", method = RequestMethod.GET)
    public List<Store> listStore() {
        return storeRepository.findAll();
    }

    @Secured("ROLE_USER")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @RequestMapping(value = "/stores/{id}", method = RequestMethod.GET)
    public Optional<Store> getOne(@PathVariable(value = "id") Long id) {
        return storeRepository.findById(id);
    }

}
