package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class OperatorsCharacteristics {

    private HashMap<String, Integer> precedence_Map = new HashMap<String, Integer>();
    private HashMap<String, Character> associativity_Map = new HashMap<String, Character>();

    int x;

    public OperatorsCharacteristics() {
        createMaps();
    }

    private void createMaps() {

        //For Precedence Map Initialization
        precedence_Map.put("/", 2);
        precedence_Map.put("*", 2);
        precedence_Map.put("-", 1);
        precedence_Map.put("+", 1);

        //For Associativity Map Initialization
        associativity_Map.put("/", 'L');
        associativity_Map.put("*", 'L');
        associativity_Map.put("-", 'L');
        associativity_Map.put("+", 'L');
    }

    /*-----Checks Precedence------*/
    public char checkPrecedence(String input, String stack_top) {
        int p1 = precedence_Map.get(input);
        int p2 = precedence_Map.get(stack_top);

        if (p1 > p2) {
            return 'H';
        } else if (p1 < p2) {
            return 'L';
        } else return 'E';
    }

    /*-----Checks Associativity---*/
    public char checkAssociativity(String input) {

        return associativity_Map.get(input);

    }

    /*-----Checks String is Numeric or Not--*/

    public boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    /*-----Evaluation-----------------------*/

    public String evaluate(ArrayList<String> postfix) {

        int i;
        Stack<String> stack = new Stack<String>();

        int size=postfix.size();

        for (i=0;i<size;i++) {
            if(isNumeric(postfix.get(i))){
                stack.push(postfix.get(i));
            }
            else{
                String operator = postfix.get(i);
                String operand2 = stack.pop();
                String operand1 = stack.pop();
                String result=calculate(operand1, operand2, operator);
                stack.push(result);


                System.out.println(postfix.get(i-1));
//

            }
        }

        return stack.pop();
    }

    private String calculate(String operand1, String operand2, String operator) {
        double v1 = Double.parseDouble(operand1);
        double v2 = Double.parseDouble(operand2);
        double result=0;

        switch (operator) {
            case "+":
                result = v1 + v2;

                break;
            case "-":
                result = v1 - v2;
                break;
            case "*":
                result = v1 * v2;
                break;
            case "/":
                result = v1 / v2;
                break;
            default:
                System.out.println("Exception");
                break;
        }


        return String.valueOf(result);

    }
}
