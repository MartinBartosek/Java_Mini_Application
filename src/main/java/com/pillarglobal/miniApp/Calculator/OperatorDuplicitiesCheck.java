package com.pillarglobal.miniApp.Calculator;

import com.pillarglobal.miniApp.Calculator.exceptions.MultipleOperatorException;
import org.springframework.stereotype.Component;

@Component
public class OperatorDuplicitiesCheck {

    public boolean checkOperatorDuplicities(char currentOperator, char anyStackOperator) throws MultipleOperatorException {
        if (currentOperator == anyStackOperator) {
            throw new MultipleOperatorException("You cannot use the same operator more than one time in a row !!!");
        }
        return true;
    }
}
