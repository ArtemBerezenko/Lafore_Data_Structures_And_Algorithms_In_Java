package com.home.Chapter_5_Linked_Lists.Example_3;

/**
 * Created by Home on 06.12.2016.
 */
public class FirstLastApp {
    public static void main(String[] args) {
        FirstLastList theList = new FirstLastList();

        theList.insertFirst(22);
        theList.insertFirst(44);
        theList.insertFirst(66);

        theList.insertLast(11);
        theList.insertLast(33);
        theList.insertLast(55);

        theList.displayList();

        theList.deleteFirst();
        theList.deleteFirst();

        theList.displayList();
    }
}
