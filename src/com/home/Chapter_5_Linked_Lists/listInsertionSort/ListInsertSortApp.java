package com.home.Chapter_5_Linked_Lists.listInsertionSort;

/**
 * Created by Home on 09.12.2016.
 */
public class ListInsertSortApp {
    public static void main(String[] args) {
        int size = 10;
        Link[] linkArray = new Link[size];
        for(int i = 0; i < size; ++i){
            int n = (int)(java.lang.Math.random()*99);
            Link newLink = new Link(n);
            linkArray[i] = newLink;
        }

        System.out.println("Unsorted array: ");
        for(int j = 0; j < size; j++) {
            System.out.print(linkArray[j].dData + " ");
        }
            System.out.println("");

        SortedList theSortedList = new SortedList(linkArray);
        for(int i = 0; i < size; ++i){
            linkArray[i] = theSortedList.remove();
        }
        System.out.println("Sorted Array: ");
        for(int j = 0; j < size; j++){
            System.out.print(linkArray[j].dData + " ");
        }
        System.out.println("");

    }
}
