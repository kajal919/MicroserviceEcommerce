package com.scaler.paymentservicejan31capstone.service;

import org.springframework.stereotype.Service;

@Service
public interface PaymentGateway {
    String generatePaymentLink();
}
