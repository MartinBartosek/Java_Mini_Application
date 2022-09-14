package com.pillarglobal.miniApp.Calculator.controllers;

import com.pillarglobal.miniApp.Calculator.controllers.services.CalculatorService;
import com.pillarglobal.miniApp.Calculator.exceptions.MultipleOperatorException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CalculatorController {

private final CalculatorService calculatorService;

public static final String CALCULATOR_CALCULATE_EXPRESSION = "/calculate/{expression}";

@GetMapping(path = CALCULATOR_CALCULATE_EXPRESSION)
public Integer calculateExpression(@PathVariable String expression) throws MultipleOperatorException {
    return calculatorService.calculate(expression);
    }
}
