package com.scaler.projectservicejan31capstone.Calculator;

import org.springframework.stereotype.Controller;

@Controller
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public int add(int a, int b) {
        System.out.println("Some logic is called");
        System.out.println("Some logic before adding");
        int result = calculatorService.addInService(a, b);
        System.out.println("Some logic after adding");
        return result;

    }
}
