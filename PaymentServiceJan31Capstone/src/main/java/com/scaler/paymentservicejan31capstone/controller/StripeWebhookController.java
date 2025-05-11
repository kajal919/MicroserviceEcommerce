package com.scaler.paymentservicejan31capstone.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StripeWebhookController {
    @PostMapping("/stripeWebhook")
    public void webhook(@RequestBody Object object) {
        System.out.println(object);
    }
}
