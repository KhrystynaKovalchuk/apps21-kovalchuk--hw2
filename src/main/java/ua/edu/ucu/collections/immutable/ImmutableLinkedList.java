package ua.edu.ucu.collections.immutable;

public final class ImmutableLinkedList implements ImmutableList {
    private final Node head;
    private final Node tail;
    private final int length;

    public ImmutableLinkedList(Object[] elements) {
        Node prev = new Node();

        prev.setValue(elements[0]);
        prev.setPrevious(null);

        head = prev;

        for (int i = 1; i < elements.length - 1; i ++) {
            Node node = new Node();

            node.setValue(elements[i]);
            node.setPrevious(prev);
            prev.setNext(node);

            prev = node;
        }

        tail = new Node();
        tail.setValue(elements[elements.length-1]);
        tail.setPrevious(prev);
        tail.setNext(null);
        prev.setNext(tail);

        length = elements.length;

    }

    public ImmutableLinkedList() {
        head = null;
        tail = null;
        length = 0;
    }

    @Override
    public ImmutableList add(Object e) {
        return addLast(e);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        return addAll(index, new Object[] {e});
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(size(), c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        if (index > length || index < 0){
            throw new IllegalArgumentException();
        }

        Object[] els = new Object[length + c.length];

        int ind = 0;
        Node headNode = head;

        while (ind < index) {
            els[ind] = headNode.getValue();
            headNode = headNode.getNext();
            ind++;
        }

        for (Object element: c){
            els[ind] = element;
            ind++;
        }

        while (headNode != null) {
            els[ind] = headNode.getValue();
            headNode = headNode.getNext();
            ind++;
        }
        return new ImmutableLinkedList(els);
    }

    @Override
    public Object get(int index) {
        if (index > length || index < 0){
            throw new IllegalArgumentException();
        }

        Node nodeHead = head;

        int counter = 0;
        while (counter != index) {
            nodeHead = nodeHead.getNext();
            counter++;
        }
        return nodeHead.getValue();
    }

    @Override
    public ImmutableList remove(int index) {
        Object[] els = new Object[this.length-1];

        int counter = 0;
        Node nodeHead = this.head;

        for (int i = 0; i < size(); i++){
            if (i != index) {
                els[counter++] = nodeHead.getValue();
                nodeHead = nodeHead.getNext();
            }
        }
        return new ImmutableLinkedList(els);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        if (index > size() || index < 0) {
            throw new IllegalArgumentException();
        }
        Object[] els = new Object[size()];
        Node headNode = head;

        for (int i = 0; i<size(); i++) {
            if (i != index) {
                els[i] = headNode.getValue();
            }
            else {
                els[i] = e;
            }
            headNode = headNode.getNext();
        }
        return new ImmutableLinkedList(els);
    }

    @Override
    public int indexOf(Object e) {
        Node headNode = head;

        for (int i =0; i < size(); i++) {
            if (headNode.getValue() == e) {
                return i;
            }
            headNode = headNode.getNext();
        }
        return -1;
    }

    @Override
    public int size() {
        return this.length;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] els = new Object[size()];
        Node nodeHead = head;
        for (int i = 0; i < size(); i++) {
            els[i] = nodeHead.getValue();
            nodeHead = nodeHead.getNext();
        }
        return els;
    }

    public ImmutableLinkedList addFirst(Object e) {
        Object[] els = new Object[size() + 1];
        Node headNode = head;
        els[0] = e;
        for (int i = 1; i < size(); i++) {
            els[i] = headNode.getValue();
            headNode = headNode.getNext();
        }
        return new ImmutableLinkedList(els);
    }

    public ImmutableLinkedList addLast(Object e) {
        Object[] els = new Object[this.length + 1];
        Node nodeHead = this.head;
        for (int i = 0; i < this.length; i++) {
            els[i] = nodeHead.getValue();
            nodeHead = nodeHead.getNext();
        }
        els[this.length] = e;
        return new ImmutableLinkedList(els);
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public Object getFirst() {
        return head.getValue();
    }

    public Object getLast() {
        return tail.getValue();
    }

    public ImmutableLinkedList removeFirst() {
        Object[] els = new Object[this.length - 1];

        int ind = 0;
        Node curr = this.head.getNext();
        for (int i = 0; i < this.length - 1; i++) {
            els[ind++] = curr.getValue();
            curr = curr.getNext();
        }
        return new ImmutableLinkedList(els);
    }

    public ImmutableLinkedList removeLast() {
        if (this.length < 1) {
            return new ImmutableLinkedList();
        } else {
            Object[] els = new Object[this.length - 1];
            int ind = 0;
            Node headNode = this.head;

            for (int i = 0; i < this.length - 1; i++) {
                els[ind++] = headNode.getValue();
                headNode = headNode.getNext();
            }
            return new ImmutableLinkedList(els);
        }
    }
    }
