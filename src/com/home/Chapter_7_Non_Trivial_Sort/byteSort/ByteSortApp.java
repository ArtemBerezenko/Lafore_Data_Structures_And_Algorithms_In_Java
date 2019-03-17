package com.home.Chapter_7_Non_Trivial_Sort.byteSort;

import com.home.Chapter_7_Non_Trivial_Sort.quickSort3.ArrayIns;

import java.util.Random;

public class ByteSortApp {
    public static void main(String[] args) {
        int maxSize = 7;
        ArrayIns arr = new ArrayIns(maxSize);
        Random rand= new Random();

        for (int i = 0; i < maxSize; i++) {
            int number = rand.nextInt(900) + 100;
            arr.insert(number);
        }
        arr.display();
//        arr.quickSort();
//        arr.display();
    }
}
