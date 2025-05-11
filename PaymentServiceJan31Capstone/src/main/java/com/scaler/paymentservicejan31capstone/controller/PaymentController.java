package com.scaler.paymentservicejan31capstone.controller;

import com.scaler.paymentservicejan31capstone.service.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    PaymentService paymentService;
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;

    }

    @PostMapping("/payment")
    public String initiatePayment() {
        return paymentService.initiatePayment();
    }
}
