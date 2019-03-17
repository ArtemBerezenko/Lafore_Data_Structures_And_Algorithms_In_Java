package com.home.Chapter_5_Linked_Lists.LinkStack;

/**
 * Created by Home on 07.12.2016.
 */
public class LinkStack {
    private LinkList theList;

    public LinkStack() {
        theList = new LinkList();
    }

    public void push(long j){
        theList.insertFirst(j);
    }

    public long pop(){
        return theList.deleteFirst();
    }

    public boolean isEmpty(){
        return (theList.isEmpty());
    }

    public void displayStack(){
        System.out.println("Stack (top-->bottom): ");
        theList.displayList();
    }
}
