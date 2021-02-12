package com.company;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {





    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        while (true) {
            ArrayList<Character> inputs = new ArrayList<Character>();
            String exp = "";
            System.out.print("Enter a expression: ");
            exp = scanner.nextLine();
            System.out.println(exp);

            for (int i = 0; i < exp.length(); i++) {
                inputs.add(exp.charAt(i));
            }

            //        inputs.add('(');
            //        inputs.add('2');
            //        inputs.add('.');
            //        inputs.add('5');
            //        inputs.add('+');
            //        inputs.add('3');
            //        inputs.add(')');
            //        inputs.add('*');
            //        inputs.add('4');
            //        inputs.add('^');
            //        inputs.add('2');
            //        inputs.add('+');
            //        inputs.add('(');
            //        inputs.add('3');
            //        inputs.add('-');
            //        inputs.add('2');
            //        inputs.add('*');
            //        inputs.add('(');
            //        inputs.add('5');
            //        inputs.add('*');
            //        inputs.add('2');
            //        inputs.add(')');
            //        inputs.add(')');
            //        inputs.add('/');
            //        inputs.add('4');
            //        inputs.add('3');


            //infix
            System.out.println("the infix");
            InfixCrater infixCrater = new InfixCrater();
            infixCrater.setInputArray(inputs);
            ArrayList<String> list = infixCrater.infixGen();

            for (String val : list) {
                System.out.print(val);
            }
            System.out.println();
            //POSTFIX
            System.out.println("the post fix");
            PosixCreator posixCreator = new PosixCreator();
            posixCreator.setInfix(list);
            ArrayList<String> postfix = posixCreator.postfixGen();

            for (String val : postfix) {
                System.out.print(val + " ");
            }
            System.out.println();
            //

            OperatorsCharacteristics operatorsCharacteristics = new OperatorsCharacteristics();
            System.out.println(operatorsCharacteristics.evaluate(postfix));


        }
    }


    }

