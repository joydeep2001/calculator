package com.company;

import java.util.ArrayList;
import java.util.Stack;

class PosixCreator {

    private ArrayList<String> infix = new ArrayList<String>();

    private ArrayList<String> postfix = new ArrayList<>();

    private Stack<String> stack = new Stack<String>();

    OperatorsCharacteristics operatorsCharacteristics = new OperatorsCharacteristics();



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
        String val;

        for (int i = 0;i < infix.size();i++) {
            val = infix.get(i);
            if(val.isEmpty()) continue;
            System.out.println("val "+val);
            if (operatorsCharacteristics.isNumeric(val)) {
                postfix.add(val);
            } else {

                if (stack.empty()) {
                    stack.push(val);
                } else {

                    if(val.equals("(")){
                        stack.push(val);
                    }
                    else if(val.equals(")")){
                        System.out.println("here");
                        //adding the content up to opening bracket found
//                        for(String temp = stack.pop();!temp.equals("(");postfix.add(temp));
                        while (!stack.peek().equals("(")){
                            String temp = stack.pop();
                            postfix.add(temp);
                        }
                        //for removing the "(" from the stack
                        stack.pop();
                    }

                    else if (operatorsCharacteristics.checkPrecedence(val, stack.peek()) == 'L') {

                        move_operators_to_postfix_until_lower_precidence_occur(val);
                        stack.push(val);
                    } else if (operatorsCharacteristics.checkPrecedence(val, stack.peek()) == 'H') {
                        stack.push(val);
                    } else {
                        if (operatorsCharacteristics.checkAssociativity(val) == 'R') {
                            stack.push(val);
                        } else {
                            String x = stack.pop();
                            postfix.add(x);
                            stack.push(val);
                        }

                    }
                }
            }

        }
        while (!stack.empty()) {
            postfix.add(stack.pop());
        }

        return postfix;
    }

    private void move_operators_to_postfix_until_lower_precidence_occur(String val) {
        while (operatorsCharacteristics.checkPrecedence(val,stack.peek())== 'L') {

            String x=stack.pop();
            postfix.add(x);

        }

    }

}
