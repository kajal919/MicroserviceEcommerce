package com.scaler.paymentservicejan31capstone.service;

import org.springframework.stereotype.Service;

@Service
public class PaymentGatewaySelectorImpl implements PaymentGatewaySelector {

    RazorpayGateway razorpayGateway;
    StripeGateway stripeGateway;

    public PaymentGatewaySelectorImpl(RazorpayGateway razorpayGateway, StripeGateway stripeGateway) {
        this.razorpayGateway = razorpayGateway;
        this.stripeGateway = stripeGateway;

    }

    @Override
    public PaymentGateway get() {
        //logic to select payment gateway dynamically
        return stripeGateway;
    }
}
