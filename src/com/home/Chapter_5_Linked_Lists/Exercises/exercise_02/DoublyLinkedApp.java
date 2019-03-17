package com.home.Chapter_5_Linked_Lists.Exercises.exercise_02;

/**
 * Created by Home on 22.02.2017.
 */
public class DoublyLinkedApp {
    public static void main(String[] args) {
        Deque deque = new Deque();
        deque.insertLeft(10);
        deque.insertLeft(20);
        deque.insertLeft(30);
        deque.insertRight(40);
        deque.insertRight(50);
        deque.insertRight(60);
        deque.display();

        System.out.println("Peek left: " + deque.peekLeft());

        deque.removeLeft();
        System.out.println("Peek left: " + deque.peekLeft());

        deque.removeRight();
        deque.removeRight();
        deque.insertRight(125);
        deque.display();
    }
}
