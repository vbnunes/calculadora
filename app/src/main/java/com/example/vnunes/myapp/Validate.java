package com.example.vnunes.myapp;

import java.util.Arrays;
import java.util.List;

public class Validade {
    private static List<String> OPERATORS = Arrays.asList("+", "-", "*", "/");

    public static boolean validadeExpression(String expression){
        char[] tokens = expression.toCharArray();

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
