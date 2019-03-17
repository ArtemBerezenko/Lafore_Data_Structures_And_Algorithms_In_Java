package com.home.Chapter_5_Linked_Lists.Example_1;

/**
 * Created by Home on 05.12.2016.
 */
public class Link {
    public int iData;
    public double dData;
    public Link next;

    public Link(int iData, double dData) {
        this.iData = iData;
        this.dData = dData;
    }

    public void displayLink(){
        System.out.println("{" + iData + ", " + dData + "} ");
    }
}
