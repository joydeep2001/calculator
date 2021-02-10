package com.company;

import java.util.ArrayList;
import java.util.Stack;

class PosixCreator {

    private ArrayList<String> infix = new ArrayList<String>();

    private ArrayList<String> postfix = new ArrayList<>();

    private Stack<String> stack = new Stack<String>();
    private  String value;

    /*-----Constructor---*/

    public PosixCreator() {
    }

    /*-----Getters & Setters----*/

    public ArrayList<String> getInfix() {
        return infix;
    }

    public void setInfix(ArrayList<String> infix) {
        this.infix = infix;
    }


    /*-------Methods---------*/

    public ArrayList<String> postfixGen() {

        OperatorsCharacteristics operatorsCharacteristics=new OperatorsCharacteristics();
        value = "";
        for (String val : infix) {

            if (operatorsCharacteristics.isNumeric(val)) {
                value += val;
                postfix.add(value);
            } else {
                value = "";
                if (stack.empty()) {
                    stack.push(val);
                } else {

                    if (operatorsCharacteristics.checkPrecedence(val, stack.peek()) == 'L') {
                        String x = stack.pop();
                        postfix.add(x);
                        stack.push(val);
                    } else if (operatorsCharacteristics.checkPrecedence(val, stack.peek()) == 'H') {
                        stack.push(val);
                    } else {
                        if(operatorsCharacteristics.checkAssociativity(val)=='R')
                        {
                            stack.push(val);
                        }
                        else {
                            String x=stack.pop();
                            postfix.add(x);
                            stack.push(val);
                        }

                    }
                }
            }

        }
        while (!stack.empty())
        {
            postfix.add(stack.pop());
        }

        return postfix;
    }

}
