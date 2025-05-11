package com.scaler.paymentservicejan31capstone.service;

import org.springframework.stereotype.Service;

@Service
public class RazorpayGateway implements PaymentGateway {
    @Override
    public String generatePaymentLink() {
        return "";
    }
}
