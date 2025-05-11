package com.scaler.projectservicejan31capstone.Calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.bean.override.mockito.MockitoBean;


@SpringBootTest
public class CalculatorControllerTest {

//    CalculatorService calculatorService =
//            Mockito.mock(CalculatorService.class);
//
//    CalculatorController calculatorController =
//            new CalculatorController(calculatorService);

    @MockitoBean
    CalculatorService calculatorService;

    @Autowired
    CalculatorController calculatorController;


    @Test
    public void testAddWhenTwoIntegersArePassedReturnsInteger() {
        //Arrange
        int a = 5;
        int b = 10;
        int expextedResult = 15;

        Mockito.when(calculatorService.addInService(a, b)).thenReturn(expextedResult);


        //Act
        int actualResult = calculatorService.addInService(a, b);

        //Assert
        Assertions.assertThat(actualResult).isEqualTo(expextedResult);
    }
}
