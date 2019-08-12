package com.home.Chapter_10_234_Trees.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Tree234App {
    //Exercise 3: Sort array with tree
    public static void sort(long[] theArray, int counter) {
        Tree234 sortingTree = new Tree234();
        //insert all values into the tree
        for (int j = 0; j < counter; j++)
            sortingTree.insert(theArray[j]);
        sortingTree.sortTraverse(theArray);
    }

    public static void main(String[] args) throws IOException {
        long value;
        Tree234 theTree = new Tree234();

        theTree.insert(50);
        theTree.insert(40);
        theTree.insert(60);
        theTree.insert(30);
        theTree.insert(70);

        while (true) {
            System.out.print("Enter first letter of ");
            System.out.print("show, insert, minimum, traverse, order, or find: ");
            char choice = getChar();
            switch (choice) {
                case 's':
                    theTree.displayTree();
                    break;
                case 'i':
                    System.out.print("Enter value to insert: ");
                    value = getInt();
                    theTree.insert(value);
                    break;
                case 'm':
                    theTree.findMinimum();
                    break;
                case 'o':
                    value = 0;
                    long[] arrayToSort = new long[20];
                    int counter = 0;
                    while (value != -1 && counter < 20) {
                        System.out.print("Enter value (enter '-1' to stop): ");
                        value = getInt();
                        if (value != -1) {
                            arrayToSort[counter] = value;
                            counter++;
                        }
                    }
                    System.out.println("Before sorting...");
                    for (int j = 0; j < counter; j++)
                        System.out.print(arrayToSort[j] + " ");
                    sort(arrayToSort, counter);
                    System.out.println("After sorting...");
                    for (int j = 0; j < counter; j++)
                        System.out.print(arrayToSort[j] + " ");
                    System.out.println("");
                    break;
                case 't':
                    theTree.traverseInOrder();
                    break;
                case 'f':
                    System.out.print("Enter value to find: ");
                    value = getInt();
                    int found = theTree.find(value);
                    if (found != -1)
                        System.out.println("Found " + value);
                    else
                        System.out.println("Could not find " + value);
                    break;
                default:
                    System.out.println("Invalid entry!");
            }//end switch
        }//end while
    }//end main()

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }

    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
} //end class Tree234App

