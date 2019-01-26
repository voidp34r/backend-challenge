package com.invillia.acme.controllers;

import com.invillia.acme.models.Order;
import com.invillia.acme.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@PreAuthorize("hasAnyRole('ADMIN','USER')")
@RequestMapping(value = "/api")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Secured({ "ROLE_ADMIN", "ROLE_USER" })
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public List<Order> listStore() {
        return orderRepository.findAll();
    }

    @Secured("ROLE_USER")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @RequestMapping(value = "/orders/{id}", method = RequestMethod.GET)
    public Optional<Order> getOne(@PathVariable(value = "id") Long id) {
        return orderRepository.findById(id);
    }

    @Secured("ROLE_USER")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @RequestMapping(value = "/orders/addorder", method = RequestMethod.POST)
    public Order addStore(@RequestBody Order order) {
        
        return orderRepository.save(order);
    }

    @Secured("ROLE_USER")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @RequestMapping(value = "/orders/update", method = RequestMethod.PUT)
    public Order updateStore(@RequestBody Order order) {
        Order orderUpdate = orderRepository.findById(order.getId()).get();
        orderUpdate.setId(order.getId());
        orderUpdate.setStatus(order.getStatus());
        return orderRepository.save(orderUpdate);
    }

    @Secured("ROLE_USER")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @RequestMapping(value = "/orders/delete", method = RequestMethod.DELETE)
    public Order deleteStore(@RequestBody Order order) {
        Order delOrder = orderRepository.findById(order.getId()).get();
        orderRepository.delete(orderRepository.findById(order.getId()).get());
        return delOrder;
    }

}
