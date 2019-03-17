package com.home.Chapter_5_Linked_Lists.SortedListApp;

/**
 * Created by Home on 08.12.2016.
 */
public class SortedListApp {
    public static void main(String[] args) {
        SortedList theSortedList = new SortedList();
        theSortedList.insert(20);
        theSortedList.insert(40);

        theSortedList.displayList();

        theSortedList.insert(10);
        theSortedList.insert(30);
        theSortedList.insert(50);

        theSortedList.displayList();

        theSortedList.remove();

        theSortedList.displayList();
    }
}
