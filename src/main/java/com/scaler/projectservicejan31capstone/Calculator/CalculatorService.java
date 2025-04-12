package com.scaler.projectservicejan31capstone.Calculator;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public int addInService(int a, int b) {
        System.out.println("Some logic is called");
        System.out.println("Some logic before adding");
        int result =  a + b;
        System.out.println("Some logic after adding");
        return result;
    }
}
