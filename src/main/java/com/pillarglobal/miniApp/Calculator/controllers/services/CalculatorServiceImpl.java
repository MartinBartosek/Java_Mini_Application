package com.pillarglobal.miniApp.Calculator.controllers.services;

import org.springframework.stereotype.Service;

import java.util.Stack;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    public Integer calculate(String expression) {

        char[] characters = expression.toCharArray();
        Stack<Integer> numbers = new Stack<Integer>();
        Stack<Character> operators = new Stack<Character>();

        for (int i = 0; i < characters.length; i++) {
            if (characters[i] == ' ') {
                continue;
            }

            if (characters[i] >= '0' && characters[i] <= '9') {
                StringBuffer stringBuffer = new StringBuffer();

                while
                (i < characters.length && characters[i] >= '0' && characters[i] <= '9')
                    stringBuffer.append(characters[i++]);
                numbers.push(Integer.parseInt(stringBuffer.toString()));
                i--;
            }
//            else if (characters[i] == '(')
//                operators.push(characters[i]);
//            else if (characters[i] == ')') {
//                while (operators.peek() != '(')
//                    numbers.push(applyOperations(operators.pop(),
//                            numbers.pop(),
//                            numbers.pop()));
//            }

            else if (characters[i] == '+' ||
                    characters[i] == '-' ||
                    characters[i] == '*' ||
                    characters[i] == '/') {
                while
                (!operators.empty() && hasPrecedence(characters[i], operators.peek()))
                    numbers.push(applyOperations(operators.pop(), numbers.pop(), numbers.pop()));
                operators.push(characters[i]);
            }
        }

        while (!operators.empty())
            numbers.push(applyOperations(operators.pop(), numbers.pop(), numbers.pop()));
        return numbers.pop();
    }

    public static boolean hasPrecedence(char operator_1, char operator_2) {
//        if (operator_2 == '(' || operator_2 == ')')
//            return false;
        if ((operator_1 == '*' || operator_1 == '/') && (operator_2 == '+' || operator_2 == '-'))
            return false;
        else
            return true;
    }

    public static int applyOperations(char operator, int a, int b) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return b - a;
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    throw new
                            UnsupportedOperationException(
                            "Cannot divide by zero");
                return a / b;
        }
        return 0;
    }
}
