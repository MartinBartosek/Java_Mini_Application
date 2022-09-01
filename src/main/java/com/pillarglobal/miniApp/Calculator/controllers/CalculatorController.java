package com.pillarglobal.miniApp.Calculator.controllers;

import com.pillarglobal.miniApp.Calculator.controllers.dtos.ExpressionDTO;
import com.pillarglobal.miniApp.Calculator.controllers.services.CalculatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "localhost:8080/api")
public class CalculatorController {

private final CalculatorService calculatorService;

public static final String CALCULATOR_CALCULATE_EXPRESSION = "/calculate/{expression}";

@GetMapping(path = CALCULATOR_CALCULATE_EXPRESSION)
public ExpressionDTO calculateExpression() {
    return calculatorService.calculate();
    }
}
