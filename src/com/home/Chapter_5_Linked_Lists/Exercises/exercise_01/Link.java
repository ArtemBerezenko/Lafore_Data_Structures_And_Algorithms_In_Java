package com.home.Chapter_5_Linked_Lists.Exercises.exercise_01;

/**
 * Created by Home on 18.02.2017.
 */
public class Link {
    public long dData;
    public Link next;

    public Link(long dData) {
        this.dData = dData;
    }

    public void displayLink() {
        System.out.print(dData + " ");
    }
}
