package com.pillarglobal.miniApp.Calculator;

import org.springframework.stereotype.Component;

@Component
public class OperatorApply {

    public int applyOperations(char operator, int a, int b) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return b - a;
            case '*':
                return a * b;
            case ':':
                if (a == 0)
                    throw new
                            UnsupportedOperationException(
                            "Cannot divide by zero");
                return b / a;
        }
        return 0;
    }
}
