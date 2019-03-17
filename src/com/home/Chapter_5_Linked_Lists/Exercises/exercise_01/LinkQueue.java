package com.home.Chapter_5_Linked_Lists.Exercises.exercise_01;

/**
 * Created by Home on 19.02.2017.
 */
public class LinkQueue {
    private SortedList theList;

    public LinkQueue() {
        theList = new SortedList();
    }

    public boolean isEmpty() {
        return theList.isEmpty();
    }

    public void insert(long j) {
        theList.insert(j);
    }

    public long remove() {
        return theList.deleteFirst();
    }

    public void displayQueue() {
        System.out.println("Queue (front-->rear: ");
        theList.displayList();
    }
}
