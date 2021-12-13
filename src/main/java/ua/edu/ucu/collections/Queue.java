package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    private ImmutableLinkedList queue;

    public Queue() {
        queue = new ImmutableLinkedList();
    }
    public Object peek() {
        return this.queue.getFirst();
    }

    public Object dequeue() {
        Object els = this.queue.getFirst();
        this.queue = this.queue.removeFirst();
        return els;
    }

    public void enqueue(Object e) {
        this.queue = this.queue.addLast(e);
    }
}
