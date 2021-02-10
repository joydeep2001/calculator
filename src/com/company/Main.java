package com.company;


import java.util.ArrayList;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> inputs = new ArrayList<String>();
        inputs.add("2");
        inputs.add(".");
        inputs.add("5");
        inputs.add("+");
        inputs.add("3");
        inputs.add("*");
        inputs.add("4");
        inputs.add("^");
        inputs.add("2");
        inputs.add("^");
        inputs.add("3");


        System.out.println("The Input Expression Is:: ");

        for (String val : inputs) {
            System.out.print(val);
        }
        System.out.println();

        PosixCreator posixCreator=new PosixCreator();
        posixCreator.setInfix(inputs);
        ArrayList<String> list = posixCreator.postfixGen();

        for (String val : list) {
            System.out.print(val);
        }
        System.out.println();

        OperatorsCharacteristics operatorsCharacteristics=new OperatorsCharacteristics();


        System.out.println(operatorsCharacteristics.evaluate(list));


    }

}