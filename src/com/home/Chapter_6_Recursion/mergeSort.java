package com.home.Chapter_6_Recursion;

class DArray {
    private long[] theArray;
    private int nElems;

    public DArray(int max) {
        this.theArray = new long[max];
        this.nElems = 0;
    }
    public void insert(long value) {
        theArray[nElems++] = value;
    }
    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(theArray[i] + " ");
            System.out.println("");
        }
    }
    public void mergeSort() {
        long[] workSpace = new long[nElems];
        recMergeSort(workSpace, 0, nElems - 1);
    }
    public void recMergeSort(long[] workSpace, int lowerBound, int upperBound) {
        if (lowerBound == upperBound) {
            return;
        } else {
            int mid = (lowerBound + upperBound) / 2;
            recMergeSort(workSpace, lowerBound, mid);
            recMergeSort(workSpace, mid + 1, upperBound);
            merge(workSpace, lowerBound, mid + 1, upperBound);
        }
    }
    public void merge(long[] workSpace, int lowPtr, int highPtr, int upperBound) {
        int i = 0;
        int lowerBound = lowPtr;
        int mid = highPtr - 1;
        int n = upperBound;

        while (lowPtr <= mid && highPtr <= upperBound) {
            if (theArray[lowPtr] < theArray[highPtr]) {
                workSpace[i++] = theArray[lowPtr++];
            } else {
                workSpace[i++] = theArray[highPtr++];
            }
        }
        while (lowPtr <= mid) {
            workSpace[i++] = theArray[lowPtr++];
        }
        while (highPtr <= upperBound) {
            workSpace[i++] = theArray[highPtr++];
        }
        for (i = 0; i < n; i++) {
            theArray[lowerBound + i] = workSpace[i];
        }
    }
}

public class mergeSort {
    public static void main(String[] args) {
        int maxSize = 100;
        DArray arr;
        arr = new DArray(maxSize);

        arr.insert(64);
        arr.insert(21);
        arr.insert(33);
        arr.insert(70);
        arr.insert(12);
        arr.insert(85);
        arr.insert(44);
        arr.insert(3);
        arr.insert(99);
        arr.insert(0);
        arr.insert(108);
        arr.insert(36);

//        Random randomGenerator = new Random();
//        for (int idx = 1; idx <= 10; ++idx) {
//            int randomInt = randomGenerator.nextInt(1000);
//            arr.insert(randomInt);
//        }

        arr.display();
        System.out.println("--------------------------------------");
        arr.mergeSort();

        arr.display();
    }
}
