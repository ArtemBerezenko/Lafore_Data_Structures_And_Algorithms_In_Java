package com.home.Chapter_7_Non_Trivial_Sort.quickSort2;

public class ArrayIns {
    private long[] theArray;
    private int nElems;

    public ArrayIns(int max) {
        this.theArray = new long[max];
        this.nElems = 0;
    }

    public void insert(long value) {
        theArray[nElems] = value;
        nElems++;
    }

    public void display() {
        System.out.print("A = ");
        for (int i = 0; i < nElems; i++)
            System.out.print(theArray[i] + " ");
        System.out.println("");
    }

    public void quickSort() {
        recQuickSort(0, nElems - 1);
    }

    public void recQuickSort(int left, int right) {
        int size = right - left + 1;
        if (size <= 3)
            manualSort(left, right);
        else {
            long median = medianOf3(left, right);
            int partition = partitionIt(left, right, median);
            recQuickSort(left, partition - 1);
            recQuickSort(partition + 1, right);
        }
    }

    private long medianOf3(int left, int right) {
        int center = (left + right) / 2;

        if (theArray[left] > theArray[center])
            swap(left, center);

        if (theArray[left] > theArray[right])
            swap(left, right);

        if (theArray[center] > theArray[right])
            swap(center, right);

        swap(center, right - 1);
        return theArray[right - 1];
    }

    private void swap(int dex1, int dex2) {
        long temp = theArray[dex1];
        theArray[dex1] = theArray[dex2];
        theArray[dex2] = temp;
    }

    private int partitionIt(int left, int right, long pivot) {
        int leftPtr = left;
        int rigthPtr = right - 1;

        while (true) {

            while (theArray[++leftPtr] < pivot)
                ;

            while (theArray[--rigthPtr] > pivot)
                ;

            if (leftPtr >= rigthPtr)
                break;
            else
                swap(leftPtr, rigthPtr);
        }
        swap(leftPtr, right - 1);
        return leftPtr;
    }

    public void manualSort(int left, int right) {
        int size = right - left + 1;
        if (size <= 1)
            return;
        if (size == 2) {
            if (theArray[left] > theArray[right])
                swap(left, right);
            return;
        } else {
            if (theArray[left] > theArray[right - 1])
                swap(left, right - 1);
            if (theArray[left] > theArray[right])
                swap(left, right);
            if (theArray[right - 1] > theArray[right])
                swap(right - 1, right);
        }
    }
}
