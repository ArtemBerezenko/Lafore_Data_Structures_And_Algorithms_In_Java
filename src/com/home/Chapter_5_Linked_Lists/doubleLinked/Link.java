package com.home.Chapter_5_Linked_Lists.doubleLinked;

/**
 * Created by Home on 09.12.2016.
 */
public class Link {
    public long dData;
    public Link next;
    public Link previous;

    public Link(long d){
        dData = d;
    }

    public void displayLink(){
        System.out.print(dData + " ");
    }
}
