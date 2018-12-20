package com.example.vnunes.myapp;

import java.util.Arrays;
import java.util.List;

public class Validate {
    private static List<Character> OPERATORS = Arrays.asList('+', '-', '*', '/');

    public static boolean validadeExpression(String expression){
        char[] tokens = expression.toCharArray();

        if(expression.matches(""))
            return false;

        if(tokens[0] == ')')
            return false;

        if(OPERATORS.contains(tokens[0]) || OPERATORS.contains(tokens[tokens.length-1]))
            return false;

        for(int i=0;i<tokens.length;i++) {
            if(OPERATORS.contains(tokens[i]) && OPERATORS.contains(tokens[i+1])){
                return false;
            }
        }

        return true;
    }
}
