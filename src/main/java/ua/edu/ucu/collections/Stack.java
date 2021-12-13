package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList stack;

    public Stack() {
        stack = new ImmutableLinkedList();
    }
    public void push(Object e) {
        this.stack = this.stack.addLast(e);
    }

    public Object pop() {
        Object els = this.stack.getLast();
        this.stack = this.stack.removeLast();
        return els;
    }

    public Object peek() {
        return this.stack.getLast();
    }
}
