package com.invillia.acme.controllers;


import com.invillia.acme.models.MyPayment;
import com.invillia.acme.repository.PaymentRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;



import java.util.List;
import java.util.Optional;

@RestController
@PreAuthorize("hasAnyRole('ADMIN','USER')")
@RequestMapping(value = "/api")
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository;

    @Secured({ "ROLE_ADMIN", "ROLE_USER" })
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/payments", method = RequestMethod.GET)
    public List<MyPayment> listPayment() {
        return paymentRepository.findAll();
    }

    @Secured("ROLE_USER")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @RequestMapping(value = "/payments/{id}", method = RequestMethod.GET)
    public Optional<MyPayment> getOne(@PathVariable(value = "id") Long id) {
        return paymentRepository.findById(id);
    }

    @Secured("ROLE_USER")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @RequestMapping(value = "/payments/addpayment", method = RequestMethod.POST)
    public MyPayment addPayment(@RequestBody MyPayment payment) {
        return paymentRepository.save(payment);
    }

    @Secured("ROLE_USER")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @RequestMapping(value = "/payments/update", method = RequestMethod.PUT)
    public MyPayment updatePayment(@RequestBody MyPayment payment) {
        MyPayment ns = new MyPayment();
        ns.setId(payment.getId());
        ns.setStatus(payment.getStatus());
        ns.setCreditCard(payment.getCreditCard());
        ns.setPaymentDate(payment.getPaymentDate());
        return paymentRepository.save(ns);
    }

    @Secured("ROLE_USER")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @RequestMapping(value = "/payments/delete", method = RequestMethod.DELETE)
    public MyPayment deletePayment(@RequestBody MyPayment payment) {
        MyPayment delStore = paymentRepository.findById(payment.getId()).get();
        paymentRepository.delete(paymentRepository.findById(payment.getId()).get());
        return delStore;
    }

}
