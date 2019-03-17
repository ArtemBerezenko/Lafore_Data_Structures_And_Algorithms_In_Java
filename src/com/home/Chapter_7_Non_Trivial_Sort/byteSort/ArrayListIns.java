package com.home.Chapter_7_Non_Trivial_Sort.byteSort;

import java.util.ArrayList;
import java.util.List;

public class ArrayListIns {
    private int[] theArray;
    private int nElems;

    private List<Integer> zeroth = new ArrayList<>();
    private List<Integer> first = new ArrayList<>();
    private List<Integer> second = new ArrayList<>();
    private List<Integer> third = new ArrayList<>();
    private List<Integer> fourth = new ArrayList<>();
    private List<Integer> fifth = new ArrayList<>();
    private List<Integer> sixth = new ArrayList<>();
    private List<Integer> seventh = new ArrayList<>();
    private List<Integer> eigth = new ArrayList<>();
    private List<Integer> nineth = new ArrayList<>();

    public ArrayListIns(int max) {
        this.theArray = new int[max];
        this.nElems = 0;
    }

    public void insert(int value) {
        theArray[nElems] = value;
        nElems++;
    }

    public void display() {
        System.out.print("A=");
        for (int i = 0; i < nElems; i++) {
            System.out.print(theArray[i] + " ");
        }
        System.out.println("");
    }

    public void byteSort() {
        for (int i = 0; i < theArray.length; i++) {

        }
    }



}
