package com.home.Chapter_5_Linked_Lists.Exercises.exercise_01;

/**
 * Created by Home on 19.02.2017.
 */
public class LinkQueueApp {
    public static void main(String[] args) {
        LinkQueue theQueue = new LinkQueue();
        theQueue.insert(20);
        theQueue.insert(80);

        theQueue.displayQueue();

        theQueue.insert(40);
        theQueue.insert(60);

        theQueue.displayQueue();

        theQueue.remove();
        theQueue.remove();

        theQueue.displayQueue();
    }
}
