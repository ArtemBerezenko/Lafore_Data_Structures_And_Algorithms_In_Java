package com.home.Chapter_5_Linked_Lists.Exercises.exercise_04;

/**
 * Created by Home on 01.03.2017.
 */
public class LinkedListApp {
        public static void main(String[] args) {
            LinkedList theList = new LinkedList();

            theList.insert(1);
            theList.insert(2);
            theList.insert(3);
            theList.insert(4);
            theList.display();

            theList.delete();
            theList.display();
            theList.delete();
            theList.display();

        }
}
