package com.home.Chapter_5_Linked_Lists.Exercises.exercise_04;

/**
 * Created by Home on 27.02.2017.
 */
public class LinkedList {
    private Link current;
    private int nItems;

    public int getnItems() {
        return nItems;
    }

    public LinkedList() {
        this.current = null;
        this.nItems = 0;
    }

    public boolean isEmpty() {
        return current == null;
    }

    public Link peek() {
        return this.current;
    }

    public void insert(long dDate) {
        Link newLink = new Link(dDate);
        if (isEmpty()) {
            current = newLink;
            current.next = current;
        } else {
            newLink.next = current.next;
            current.next = newLink;
        }
        nItems++;
    }

    public void step() {
        current = current.next;
    }

    public Link find(long value) {
        for (int i = 0; i < nItems; i++) {
            if (current.dDate == value) {
                System.out.println("Found: " + value);
                return current;
            } else step();
        }
        System.out.println("Couldn't find " + value + ".");
        return null;
    }

    public Link delete() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return null;
        } else if (nItems == 1) {
            current = null;
            nItems = 0;
            return null;
        } else {
            Link temp = current.next;
            current.next = current.next.next;
            nItems--;
            return temp;
        }
    }

    public void display() {
        System.out.print("LinkedList (from current): ");
        for (int i = 0; i < nItems; i++) {
            System.out.print(current.dDate + " ");
            current = current.next;
        }
        System.out.println("");
    }
}
