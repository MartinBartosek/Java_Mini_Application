package com.pillarglobal.miniApp.Calculator.controllers.services;

import com.pillarglobal.miniApp.Calculator.OperatorApply;
import com.pillarglobal.miniApp.Calculator.OperatorDuplicitiesCheck;
import com.pillarglobal.miniApp.Calculator.PrecedenceCheck;
import com.pillarglobal.miniApp.Calculator.exceptions.MultipleOperatorException;
import org.springframework.stereotype.Service;

import java.util.Stack;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    public PrecedenceCheck precedenceCheck;
    public OperatorApply operatorApply;
    public OperatorDuplicitiesCheck operatorDuplicitiesCheck;

    public Integer solveExpression(String expression) throws MultipleOperatorException {

        char[] characters = expression.toCharArray();
        Stack<Integer> numbers = new Stack<Integer>();
        Stack<Character> operators = new Stack<Character>();

        for (int i = 0; i < characters.length; i++) {

            if (characters[i] >= '0' && characters[i] <= '9') {
                StringBuilder stringBuffer = new StringBuilder();

                while
                (i < characters.length && characters[i] >= '0' && characters[i] <= '9')
                    stringBuffer.append(characters[i++]);
                numbers.push(Integer.parseInt(stringBuffer.toString()));
                i--;
            } else if (characters[i] == '(')
                operators.push(characters[i]);
            else if (characters[i] == ')') {
                while (operators.peek() != '(')
                    numbers.push(operatorApply.applyOperations(operators.pop(), numbers.pop(), numbers.pop()));
                operators.pop();
            } else if (characters[i] == '+' ||
                    characters[i] == '-' ||
                    characters[i] == '*' ||
                    characters[i] == ':') {
                while
                (!operators.empty() && precedenceCheck.hasPrecedence(characters[i], operators.peek()) && operatorDuplicitiesCheck.checkOperatorDuplicities(characters[i], operators.peek()))
                    numbers.push(operatorApply.applyOperations(operators.pop(), numbers.pop(), numbers.pop()));
                operators.push(characters[i]);
            }
        }

        while (!operators.empty())
            numbers.push(operatorApply.applyOperations(operators.pop(), numbers.pop(), numbers.pop()));
        return numbers.pop();
    }
}
