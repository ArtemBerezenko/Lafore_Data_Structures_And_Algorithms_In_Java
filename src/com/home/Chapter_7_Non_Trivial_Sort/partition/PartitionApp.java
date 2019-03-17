package com.home.Chapter_7_Non_Trivial_Sort.partition;

public class PartitionApp {
    public static void main(String[] args) {
        int maxSize = 16;
        ArrayPar arr;
        arr = new ArrayPar(maxSize);

        for (int j = 0; j < maxSize; j++) {
            long n = (int)(Math.random() * 199);
            arr.insert(n);
        }
        arr.display();

        long pivot = 99;
        System.out.print("Pivot is " + pivot);
        int size = arr.size();
        int partDex = arr.partitionIt(0, size - 1, pivot);
        System.out.println(", Partition is at index " + partDex);
        arr.display();
    }
}
