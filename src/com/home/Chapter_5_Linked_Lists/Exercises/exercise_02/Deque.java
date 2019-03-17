package com.home.Chapter_5_Linked_Lists.Exercises.exercise_02;

/**
 * Created by Home on 27.02.2017.
 */
public class Deque {
    private DoubleLinkedList theList;

    public Deque() {
        this.theList = new DoubleLinkedList();
    }

    public long peekLeft() {
        return theList.peekFirst().dDate;
    }

    public long peekRight() {
        return theList.peekLast().dDate;
    }

    public void insertLeft(long value) {
        theList.insertFirst(value);
    }

    public long removeLeft() {
        return theList.deleteFirst().dDate;
    }

    public void insertRight(long value) {
        theList.insertLast(value);
    }

    public long removeRight() {
        return theList.deleteLast().dDate;
    }

    public boolean isEmpty() {
        return theList.isEmpty();
    }

    public void display() {
        theList.displayForward();
    }


}
