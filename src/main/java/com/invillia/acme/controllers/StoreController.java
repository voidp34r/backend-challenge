package com.invillia.acme.controllers;

import com.invillia.acme.models.Store;
import com.invillia.acme.repository.StoreRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

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
    public Optional<Store> getOne(@PathVariable(value = "id") Integer id) {
        return storeRepository.findById(id);
    }

    @Secured("ROLE_USER")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @RequestMapping(value = "/stores/addstore", method = RequestMethod.POST)
    public Store addStore(@RequestBody Store store) {
        ZoneId fusoHorario = ZoneId.of("America/Sao_Paulo");
		ZonedDateTime dateTime = ZonedDateTime.now(fusoHorario);
        store.setDatatime(dateTime);
        return storeRepository.save(store);
    }

    @Secured("ROLE_USER")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @RequestMapping(value = "/stores/update", method = RequestMethod.PUT)
    public Store updateStore(@RequestBody Store store) {
        Store ns = new Store();
        ns.setId(store.getId());
        ns.setName(store.getName());
        ns.setAndress(store.getAndress());
        return storeRepository.save(ns);
    }

    @Secured("ROLE_USER")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @RequestMapping(value = "/stores/delete", method = RequestMethod.DELETE)
    public Store deleteStore(@RequestBody Store store) {
        Store delStore = storeRepository.findById(store.getId()).get();
        storeRepository.delete(storeRepository.findById(store.getId()).get());
        return delStore;
    }

}
