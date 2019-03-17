package com.home.Chapter_6_Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Home on 11.04.2017.
 */
class GraduationApp {
    static int number;
    static int exponent;
    static int answer;

    public static void main(String[] args) throws IOException {
        System.out.print("Enter a number: ");
        number = getInt();
        System.out.print("Enter a exponent: ");
        exponent = getInt();
        answer = graduation(number, exponent);
        System.out.println("Answer=" + answer);
    }

    public static int graduation(int number, int exponent) {
        if (exponent == 1) {
            System.out.println("Returning " + number + " number = " + number + " exponent = " + exponent);
            return number;
        } else if (exponent%2 == 0) {
            System.out.println("number = " + number + " exponent = " + exponent);
            return graduation(number*number, exponent/2);
        } else {
            System.out.println("number = " + number + " exponent = " + exponent);
            return number * graduation(number, exponent - 1);
        }
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
}
