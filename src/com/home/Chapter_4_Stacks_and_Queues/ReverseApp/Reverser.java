package com.home.Chapter_4_Stacks_and_Queues.ReverseApp;

/**
 * Created by Home on 29.12.2016.
 */
public class Reverser {
    private String input;
    private String output;

    public Reverser(String in) {
        this.input = in;
    }

    public String doRev() {
        int stackSize = input.length();
        StackX theStack = new StackX(stackSize);

        for (int j = 0; j < input.length(); j++) {
            char ch = input.charAt(j);
            theStack.push(ch);
        }
            output = "";
            while (!theStack.isEmpty()) {
                char ch = theStack.pop();
                output = output + ch;
            }
            return output;
        }
}
