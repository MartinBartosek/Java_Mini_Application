package com.pillarglobal.miniApp.Calculator.controllers.services;

import com.pillarglobal.miniApp.Calculator.exceptions.MultipleOperatorException;

public interface CalculatorService {
    Integer solveExpression(String expression) throws MultipleOperatorException;
}
