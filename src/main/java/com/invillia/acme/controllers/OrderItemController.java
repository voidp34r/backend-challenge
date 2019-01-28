package com.invillia.acme.controllers;


import com.invillia.acme.models.MyOrderItem;
import com.invillia.acme.repository.OrderItemRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;



import java.util.List;
import java.util.Optional;

@RestController
@PreAuthorize("hasAnyRole('ADMIN','USER')")
@RequestMapping(value = "/api")
public class OrderItemController {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Secured({ "ROLE_ADMIN", "ROLE_USER" })
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/orderitems", method = RequestMethod.GET)
    public List<MyOrderItem> listOrderItem() {
        return orderItemRepository.findAll();
    }

    @Secured("ROLE_USER")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @RequestMapping(value = "/orderitems/{id}", method = RequestMethod.GET)
    public Optional<MyOrderItem> getOne(@PathVariable(value = "id") Long id) {
        return orderItemRepository.findById(id);
    }

    @Secured("ROLE_USER")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @RequestMapping(value = "/orderitems/addorderitem", method = RequestMethod.POST)
    public MyOrderItem addStoreOrderItem(@RequestBody MyOrderItem orderitem) {
        return orderItemRepository.save(orderitem);
    }

    @Secured("ROLE_USER")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @RequestMapping(value = "/orderitems/update", method = RequestMethod.PUT)
    public MyOrderItem updateOrderItem(@RequestBody MyOrderItem orderitem) {
        MyOrderItem ns = new MyOrderItem();
        ns.setId(orderitem.getId());
        ns.setDescription(orderitem.getDescription());
        ns.setQuantity(orderitem.getQuantity());
        ns.setUnitPrice(orderitem.getUnitPrice());
        return orderItemRepository.save(ns);
    }

    @Secured("ROLE_USER")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @RequestMapping(value = "/orderitems/delete", method = RequestMethod.DELETE)
    public MyOrderItem deleteOrderItem(@RequestBody MyOrderItem orderitem) {
        MyOrderItem delStore = orderItemRepository.findById(orderitem.getId()).get();
        orderItemRepository.delete(orderItemRepository.findById(orderitem.getId()).get());
        return delStore;
    }

}
