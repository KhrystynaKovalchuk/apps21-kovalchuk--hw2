package ua.edu.ucu.collections.immutable;

import java.util.Arrays;
import java.util.Objects;

public final class ImmutableArrayList implements ImmutableList {
    private Object[] els;

    public ImmutableArrayList(Object[] elements) {
        this.els = new Object[elements.length];
        System.arraycopy(elements, 0, this.els, 0, elements.length);
    }

    public ImmutableArrayList() {
        this.els = new Object[0];
    }

    @Override
    public ImmutableList add(Object e) {
        return add(size(), e);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        return addAll(index, new Object[]{e});
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(size(), c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        if (index > size() || index < 0){
            throw new IllegalArgumentException();
        }
        Object[] elements = new Object[size() + c.length];
        int ind = 0;

        for (int i = 0; i < index; i++) {
            elements[ind] = this.els[i];
            ind++;
        }
        for (Object o : c) {
            elements[ind] = o;
            ind++;
        }
        for (Object el : els) {
            elements[ind] = el;
            ind++;
        }
        return new ImmutableLinkedList(elements);
    }

    @Override
    public Object get(int index) {
        if (index > size() || index < 0){
            throw new IllegalArgumentException();
        }
        return this.els[index];
    }

    @Override
    public ImmutableList remove(int index) {
        Object[] elements = new Object[size()-1];

        int ind = 0;
        for (int i = 0; i < size(); i++) {
            if (i != index) {
                elements[i] = els[ind++];
            } else {
                ind++;
            }
        }
        return new ImmutableLinkedList(elements);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        Object[] elements = new Object[size()];
        System.arraycopy(els, 0, elements, 0, size());
        elements[index] = e;
        return new ImmutableLinkedList(elements);
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < size(); i++) {
            if (els[i] == e) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return this.els.length;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return this.els.length == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] elements = new Object[size()];
        System.arraycopy(this.els, 0, elements, 0, size());
        return elements;
    }
}
