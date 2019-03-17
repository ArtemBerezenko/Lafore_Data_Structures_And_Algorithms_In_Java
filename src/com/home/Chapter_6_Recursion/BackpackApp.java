package com.home.Chapter_6_Recursion;

/**
 * Created by Home on 21.04.2017.
 */
public class BackpackApp {
    static int[] items;


    public static void main(String[] args) {
        int aim = 20;
        items = new int[]{11, 8, 7, 6, 5};
        collectABag(0, aim);

    }

    public static boolean collectABag(int index, int aim) {
        boolean complete = false;

        if (index == items.length) return false;

        if (items[index] == aim) {
            System.out.println("Answer: " + items[index] + " ");
            complete = true;
        }

        if (items[index] < aim) {
            complete = collectABag(index + 1, aim - items[index]);
            if (complete) System.out.print(items[index] + " ");
            for (int i = index + 1; i < items.length; i++) {
                if (!complete) complete = collectABag(i, aim);
            }
        }
        if (items[index] > aim) complete = collectABag(index + 1, aim);

        return complete;
    }
}
