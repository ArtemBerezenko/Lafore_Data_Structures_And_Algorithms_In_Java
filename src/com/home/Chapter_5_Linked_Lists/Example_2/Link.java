package com.home.Chapter_5_Linked_Lists.Example_2;

/**
 * Created by Home on 05.12.2016.
 */
public class Link {
    public int iData;
    public double dData;
    public Link next;

    public Link(int id, double dd){
        iData = id;
        dData = dd;
    }

    public void displayLink(){
        System.out.println("{" + iData + ", " + dData + "} ");
    }
}
