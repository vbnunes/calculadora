package com.example.vnunes.myapp;

import android.app.Application;

import java.util.Stack;

public class Calculator extends Application {
    public static int solveExpression(String expression) {
        char[] tokens = expression.toCharArray();
        
        Stack<Integer> numbers = new Stack<>();
        
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < tokens.length; i++)
        {
            if (tokens[i] == ' ')
                continue;

            // Current token is a number, push it to stack for numbers
            if (tokens[i] >= '0' && tokens[i] <= '9')
            {
                StringBuffer sbuf = new StringBuffer();
                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
                    sbuf.append(tokens[i++]);
                numbers.push(Integer.parseInt(sbuf.toString()));
                i--;
            }

            // Current token is an opening brace, push it to 'operators'
            else if (tokens[i] == '(')
                operators.push(tokens[i]);

                // Closing brace encountered, solve entire brace
            else if (tokens[i] == ')')
            {
                while (operators.peek() != '(')
                    numbers.push(applyOp(operators.pop(), numbers.pop(), numbers.pop()));
                operators.pop();
            }

            // Current token is an operator.
            else if (Validate.getOPERATORS().contains(tokens[i]))
            {
                while (!operators.empty() && hasPrecedence(tokens[i], operators.peek()))
                    numbers.push(applyOp(operators.pop(), numbers.pop(), numbers.pop()));

                operators.push(tokens[i]);
            }
        }

        while (!operators.empty())
            numbers.push(applyOp(operators.pop(), numbers.pop(), numbers.pop()));

        return numbers.pop();
    }

    private static boolean hasPrecedence(char op1, char op2)
    {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }

    private static int applyOp(char op, int b, int a) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    throw new
                            UnsupportedOperationException("Cannot divide by zero");
                return a / b;
        }
        return 0;
    }
}
