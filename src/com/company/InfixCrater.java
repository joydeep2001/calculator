package com.company;

import java.util.ArrayList;

public class InfixCrater {

    private ArrayList<Character> characterArrayList = new ArrayList<Character>();

    private final ArrayList<String> infix = new ArrayList<String>();


    /*---Constructor-----*/
    public InfixCrater() {
    }

    /*---Getters--------*/
    public ArrayList<Character> getInputArray() {
        return characterArrayList;
    }

    /*---Setters--------*/
    public void setInputArray(ArrayList<Character> inputArray) {
        this.characterArrayList = inputArray;
    }

    /*----Methods-------*/

    /*-----Infix Generation Method-------*/
    public ArrayList<String> infixGen() {

        StringBuilder s = new StringBuilder();
        int i;

        OperatorsCharacteristics operatorsCharacteristics=new OperatorsCharacteristics();

        for (i = 0; i < characterArrayList.size(); i++) {
            System.out.println("out output" +Character.toString(characterArrayList.get(i)));
            if (operatorsCharacteristics.isNumeric(Character.toString(characterArrayList.get(i)))) {
                s.append(characterArrayList.get(i));

            } else {
                infix.add(s.toString());
                s = new StringBuilder();
                infix.add(String.valueOf(characterArrayList.get(i)));

            }
        }
        for (int j = i + 1; j < characterArrayList.size(); j++) {
            s = s.append(characterArrayList.get(j).toString());
        }
        infix.add(s.toString());

        return infix;
    }


    /*-----Infix Showing Method------*/
    public void show() {
        for (String val : infix) {
            System.out.print(val);
        }
    }


}
