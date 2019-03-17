package com.home.Chapter_5_Linked_Lists.SortedListApp;

/**
 * Created by Home on 08.12.2016.
 */
public class Link {
    public long dData;
    public Link next;

    public Link(long dd){
        dData = dd;
    }

    public void displayLink(){
        System.out.println(dData + " ");
    }
}
