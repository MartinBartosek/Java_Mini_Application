package com.pillarglobal.miniApp.Calculator;

import org.springframework.stereotype.Component;

@Component
public class PrecedenceCheck {

    public boolean hasPrecedence(char currentOperator, char stackOperator) {
        if (stackOperator == '(' || stackOperator == ')')
            return false;
        if ((currentOperator == '*' || currentOperator == ':') && (stackOperator == '+' || stackOperator == '-'))
            return false;
        else
            return true;
    }
}
