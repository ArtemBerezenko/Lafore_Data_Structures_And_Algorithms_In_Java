package com.home.Chapter_5_Linked_Lists.linkQueue;

/**
 * Created by Home on 07.12.2016.
 */
public class LinkQueue {
    private FirstLastList theList;

    public LinkQueue(){
        theList = new FirstLastList();
    }

    public boolean isEmpty(){
        return theList.isEmpty();
    }

    public void insert(long j){
        theList.insertLast(j);
    }

    public long remove(){
        return theList.deleteFirst();
    }

    public void displayQueue(){
        System.out.println("Queue (front-->rear): ");
        theList.displayList();
    }
}
