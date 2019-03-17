package com.home.Chapter_5_Linked_Lists.LinkStack;

/**
 * Created by Home on 07.12.2016.
 */
public class Link {
    public long dData;
    public Link next;

    public Link(long dd) {
        this.dData = dd;
    }

    public void displayLink(){
        System.out.println(dData + " ");
    }
}
