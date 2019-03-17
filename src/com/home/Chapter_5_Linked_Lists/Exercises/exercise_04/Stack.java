package com.home.Chapter_5_Linked_Lists.Exercises.exercise_04;

import java.util.EmptyStackException;

/**
 * Created by Home on 07.03.2017.
 */
public class Stack {
    private LinkedList theList;

    public Stack() {
        this.theList = new LinkedList();
        this.theList.insert(-1);
    }

    public void push(long value) {
        theList.insert(value);
    }

    public long pop() {
        if (theList.getnItems() == 1) {
            System.out.printf("Stack is empty");
            throw new EmptyStackException();
        } else {
            return theList.delete().dDate;
        }
    }

    public long peek() {
       return theList.peek().dDate;
    }




}
