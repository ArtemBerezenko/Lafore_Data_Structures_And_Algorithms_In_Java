package com.home.Chapter_5_Linked_Lists.SortedListApp;

/**
 * Created by Home on 08.12.2016.
 */
public class SortedList {
    private Link first;

    public SortedList(){
        first = null;
    }

    public boolean isEmpty(){
        return (first == null);
    }

    public void insert(long key){
        Link newLink = new Link(key);
        Link previous = null;
        Link current = first;

        while(current != null && key > current.dData){
            previous = current;
            current = current.next;
        }
        if(previous == null){
            first = newLink;
        } else {
            previous.next = newLink;
        }
        newLink.next = current;
    }

    public Link remove(){
        Link temp = first;
        first = first.next;
        return temp;
    }

    public void displayList(){
        System.out.println("List (first-->last): ");
        Link current = first;
        while(current != null){
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
}
