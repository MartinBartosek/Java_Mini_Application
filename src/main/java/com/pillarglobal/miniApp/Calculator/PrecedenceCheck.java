package com.pillarglobal.miniApp.Calculator;

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
