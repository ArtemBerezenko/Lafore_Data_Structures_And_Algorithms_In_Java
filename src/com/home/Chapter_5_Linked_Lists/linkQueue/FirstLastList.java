package com.home.Chapter_5_Linked_Lists.linkQueue;

/**
 * Created by Home on 07.12.2016.
 */
public class FirstLastList {
    private Link first;
    private Link last;

    public FirstLastList(){
        first = null;
        last = null;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void insertLast(long dd){
        Link newLink = new Link(dd);
        if(isEmpty()){
            first = newLink;
        }else{
            last.next = newLink;
        }
        last = newLink;
    }

    public long deleteFirst(){
        long temp = first.dData;
        if(first.next == null){
            last = null;
        }
        first = first.next;
        return temp;
    }

    public void displayList(){
        Link current = first;
        while(current != null){
            current.dispayLink();
            current = current.next;
        }
        System.out.println("");
    }
}
