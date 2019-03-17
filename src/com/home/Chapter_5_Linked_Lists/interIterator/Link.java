package com.home.Chapter_5_Linked_Lists.interIterator;

/**
 * Created by Home on 02.01.2017.
 */
public class Link {
    public long dData;
    public Link next;

    public Link(long dd) {
        this.dData = dd;
    }

    public void displayLink() {
        System.out.print(dData + " ");
    }
}
