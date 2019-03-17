package com.home.Chapter_7_Non_Trivial_Sort.shellSort;

public class ShellSortApp {
    public static void main(String[] args) {
        int maxSize = 10;
        ArraySh arr;
        arr = new ArraySh(maxSize);

        for (int j = 0; j < maxSize; j++) {
            long n = (int) (Math.random() * 99);
            arr.insert(n);
        }
        arr.display();
        arr.shellSort();
        arr.display();
    }
}
