package com.home.Chapter_6_Recursion.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DumpCalculator {
    private static int x;
    private static int y;

    public static int mult(int x, int y) {
        System.out.println("Entering: x = " + x);
        System.out.println("Entering: y = " + y);
        if (y == 1) {
            System.out.println("Returning x");
            return x;
        }
        else {
            int temp = x + mult(x, y - 1);
            System.out.println("Returning " + temp);
            return temp;
        }
    }

    public static String getString() throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        String s = br.readLine();
        return s;
    }

    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        System.out.print("Enter a 'x': ");
        x = getInt();
        System.out.print("Enter a 'y': ");
        y = getInt();
        int theAnswer = mult(x, y);
        System.out.println("Answer = " + theAnswer);
    }

}
