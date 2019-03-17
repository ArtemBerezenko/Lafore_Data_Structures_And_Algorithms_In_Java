package com.home.Chapter_5_Linked_Lists.linkQueue;

/**
 * Created by Home on 07.12.2016.
 */
public class Link {
    public long dData;
    public Link next;

    public Link(long d){
        dData = d;
    }

    public void dispayLink(){
        System.out.println(dData + "");
    }
}
