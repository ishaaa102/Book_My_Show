package com.Isha.bookMyShow.controllers;

import com.Isha.bookMyShow.dto.PaymentRequest;
import com.Isha.bookMyShow.entity.Payment;
import com.Isha.bookMyShow.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer/payment")
public class PaymentCustomerController {
    private final PaymentService paymentService;

    @Autowired
    public PaymentCustomerController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/create")
    public ResponseEntity<Payment> createPayment(@RequestBody PaymentRequest paymentRequest){
        return ResponseEntity.ok(paymentService.createPayment(paymentRequest));
    }

    @PostMapping("/retry/{id}")
    public ResponseEntity<Payment> retryPayment(@PathVariable String id, @RequestBody PaymentRequest paymentRequest) throws Exception {
        return ResponseEntity.ok(paymentService.retryPayment(id, paymentRequest));
    }



}
