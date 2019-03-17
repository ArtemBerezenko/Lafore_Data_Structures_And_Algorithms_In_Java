package com.home.Chapter_5_Linked_Lists.listInsertionSort;

/**
 * Created by Home on 09.12.2016.
 */
public class SortedList {
    private Link first;

    public SortedList() {
        this.first = null;
    }

    public SortedList(Link[] linkArr){
        first = null;
        for(int j = 0; j < linkArr.length; ++j){
            insert(linkArr[j]);
        }
    }

    public void insert(Link k) {
        Link previous = null;
        Link current = first;

        while(current != null && k.dData > current.dData){
            previous = current;
            current = current.next;
        }

        if(previous == null){
            first = k;
        } else {
            previous.next = k;
        }
        k.next = current;
    }

    public Link remove(){
        Link temp = first;
        first = first.next;
        return temp;
    }
}
