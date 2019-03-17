package com.home.Chapter_5_Linked_Lists.Exercises.exercise_02;

/**
 * Created by Home on 22.02.2017.
 */
public class Link {
    public long dDate;
    public Link next;
    public Link previous;

    public Link(long dDate) {
        this.dDate = dDate;
    }

    public void displayLink() {
        System.out.print(dDate + " ");
    }
}
