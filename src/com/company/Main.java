package com.company;


import java.util.ArrayList;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        ArrayList<Character> inputs = new ArrayList<Character>();
        inputs.add('2');
        inputs.add('.');
        inputs.add('5');
        inputs.add('+');
        inputs.add('3');
        inputs.add('*');
        inputs.add('4');
        inputs.add('^');
        inputs.add('2');
        inputs.add('+');
        inputs.add('(');
        inputs.add('3');
        inputs.add('*');
        inputs.add('2');
        inputs.add('*');
        inputs.add('(');
        inputs.add('5');
        inputs.add('*');
        inputs.add('2');
        inputs.add(')');
        inputs.add(')');
        inputs.add('/');
        inputs.add('4');
        inputs.add('3');






        System.out.println("The Input Expression Is:: ");

        for (Character val : inputs) {
            System.out.print(val);
        }
        System.out.println();

        System.out.println("the infix");

        InfixCrater infixCrater=new InfixCrater();
        infixCrater.setInputArray(inputs);
        ArrayList<String> list=infixCrater.infixGen();

        for (String val : list) {
            System.out.println(val);
        }

//POSTFIX
        System.out.println("the post fix");
        PosixCreator posixCreator = new PosixCreator();
        posixCreator.setInfix(list);
        ArrayList<String> postfix = posixCreator.postfixGen();

        for (String val : postfix) {
            System.out.print(val);
        }
        System.out.println();
//

        OperatorsCharacteristics operatorsCharacteristics=new OperatorsCharacteristics();


        System.out.println(operatorsCharacteristics.evaluate(postfix));


    }

}