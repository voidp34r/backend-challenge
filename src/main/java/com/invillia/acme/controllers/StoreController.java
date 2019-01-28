package com.invillia.acme.controllers;


import com.invillia.acme.models.MyStore;
import com.invillia.acme.repository.StoreRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;



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
    public List<MyStore> listStore() {
        return storeRepository.findAll();
    }

    @Secured("ROLE_USER")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @RequestMapping(value = "/stores/{id}", method = RequestMethod.GET)
    public Optional<MyStore> getOne(@PathVariable(value = "id") Long id) {
        return storeRepository.findById(id);
    }

    @Secured("ROLE_USER")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @RequestMapping(value = "/stores/addstore", method = RequestMethod.POST)
    public MyStore addStorePost(@RequestBody MyStore store) {
        return storeRepository.save(store);
    }

    @Secured("ROLE_USER")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @RequestMapping(value = "/stores/update", method = RequestMethod.PUT)
    public MyStore updateStore(@RequestBody MyStore store) {
        MyStore ns = new MyStore();
        ns.setId(store.getId());
        ns.setName(store.getName());
        ns.setAddress(store.getAddress());
        ns.setMyOrders(store.getMyOrders());
        return storeRepository.save(ns);
    }

    @Secured("ROLE_USER")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @RequestMapping(value = "/stores/delete", method = RequestMethod.DELETE)
    public MyStore deleteStore(@RequestBody MyStore store) {
        MyStore delStore = storeRepository.findById(store.getId()).get();
        storeRepository.delete(storeRepository.findById(store.getId()).get());
        return delStore;
    }

}
