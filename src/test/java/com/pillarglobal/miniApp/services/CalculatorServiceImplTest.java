package com.pillarglobal.miniApp.services;

import com.pillarglobal.miniApp.Calculator.controllers.services.CalculatorServiceImpl;
import com.pillarglobal.miniApp.Calculator.exceptions.MultipleOperatorException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class CalculatorServiceImplTest {

    @InjectMocks
    private CalculatorServiceImpl calculatorService;

    @BeforeEach
    void beforeEach() {
    }

    @Test
    void solveExpressionExpression() throws MultipleOperatorException {
        //given
        String testExpression = "2*3-2";
        //when
        int result = calculatorService.solveExpression(testExpression);
        //then
        assertThat(result).isEqualTo(4);
        assertThat(result).isNotNull();
    }

    @Test
    void solveExpressionShouldThrowExceptionWhenSameOperatorsAreUsedInARow() {
        //given
        String testExpression = "3+++++5";
        //then
        assertThrows(MultipleOperatorException.class, () -> calculatorService.solveExpression(testExpression));
    }

    @Test
    void hasPrecedence() {

    }

    @Test
    void applyOperations() {
    }
}