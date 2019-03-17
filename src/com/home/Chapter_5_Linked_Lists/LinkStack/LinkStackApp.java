package com.home.Chapter_5_Linked_Lists.LinkStack;

/**
 * Created by Home on 07.12.2016.
 */
public class LinkStackApp {
    public static void main(String[] args) {
        LinkStack theStack = new LinkStack();

        theStack.push(20);
        theStack.push(40);

        theStack.displayStack();

        theStack.push(60);
        theStack.push(80);

        theStack.displayStack();

        theStack.pop();
        theStack.pop();

        theStack.displayStack();
    }
}
