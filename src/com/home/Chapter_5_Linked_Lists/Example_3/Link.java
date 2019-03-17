package com.home.Chapter_5_Linked_Lists.Example_3;

/**
 * Created by Home on 06.12.2016.
 */
public class Link {
    public long dData;
    public Link next;

    public Link(long d){
        dData = d;
    }

    public void displayLink(){
        System.out.println(dData + " ");
    }
}
