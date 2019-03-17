package com.home.Chapter_5_Linked_Lists.Exercises.exercise_04;

/**
 * Created by Home on 13.03.2017.
 */
public class Main {

    public static void main(String[] args)
    {
        Stack theStack = new Stack();
        theStack.push(2);
        theStack.push(5);
        theStack.push(8);
        theStack.push(2);

        System.out.println(theStack.pop());
        System.out.println(theStack.pop());
        System.out.println(theStack.pop());
        System.out.println(theStack.pop());

    }
}
