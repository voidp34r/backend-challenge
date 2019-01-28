package com.invillia.acme.controllers;

import com.invillia.acme.models.MyOrder;
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
    public List<MyOrder> listOrder() {
        return orderRepository.findAll();
    }

    @Secured("ROLE_USER")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @RequestMapping(value = "/orders/{id}", method = RequestMethod.GET)
    public Optional<MyOrder> getOne(@PathVariable(value = "id") Long id) {
        return orderRepository.findById(id);
    }

    @Secured("ROLE_USER")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @RequestMapping(value = "/orders/addorder", method = RequestMethod.POST)
    public MyOrder addOrder(@RequestBody MyOrder order) {
        return orderRepository.save(order);
    }

    @Secured("ROLE_USER")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @RequestMapping(value = "/orders/update", method = RequestMethod.PUT)
    public MyOrder updateOrder(@RequestBody MyOrder order) {
        MyOrder orderUpdate = orderRepository.findById(order.getId()).get();
        orderUpdate.setId(order.getId());
        orderUpdate.setStatus(order.getStatus());
        orderUpdate.setMyOrderItems(order.getMyOrderItems());
        return orderRepository.save(orderUpdate);
    }

    @Secured("ROLE_USER")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @RequestMapping(value = "/orders/delete", method = RequestMethod.DELETE)
    public MyOrder deleteStore(@RequestBody MyOrder order) {
        MyOrder delOrder = orderRepository.findById(order.getId()).get();
        orderRepository.delete(orderRepository.findById(order.getId()).get());
        return delOrder;
    }

}
