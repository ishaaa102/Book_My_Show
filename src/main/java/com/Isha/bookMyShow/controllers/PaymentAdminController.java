package com.Isha.bookMyShow.controllers;

import com.Isha.bookMyShow.dto.PaymentRequest;
import com.Isha.bookMyShow.entity.Payment;
import com.Isha.bookMyShow.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/payment")
public class PaymentAdminController {
    private final PaymentService paymentService;

    @Autowired
    public PaymentAdminController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/viewAll")
    public ResponseEntity<List<Payment>> getAllPayments(){
        return ResponseEntity.ok(paymentService.getAllPayments());
    }

    @GetMapping("/viewById/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable String id){
        return ResponseEntity.ok(paymentService.getPaymentById(id));
    }



}

