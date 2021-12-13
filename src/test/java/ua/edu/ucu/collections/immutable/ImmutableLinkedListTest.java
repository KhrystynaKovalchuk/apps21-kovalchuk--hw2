package ua.edu.ucu.collections.immutable;

import junit.framework.TestCase;

import static org.junit.Assert.assertArrayEquals;

public class ImmutableLinkedListTest extends TestCase {

    public void testAdd() {
        Object[] els = {3, 4, 5};
        Object el = 6;

        Object[] res = {3, 4, 5, 6};

        ImmutableLinkedList lst = new ImmutableLinkedList(els);
        ImmutableList lst_1 = lst.add(el);

        assertArrayEquals(res, lst_1.toArray());
    }

    public void testTestAdd() {
        Object[] els = {3, 4, 5};
        Object el = 7;

        Object[] res = {3, 4, 7, 5};

        ImmutableLinkedList lst = new ImmutableLinkedList(els);
        ImmutableList lst_1 = lst.add(2, el);

        assertArrayEquals(res, lst_1.toArray());
    }

    public void testAddAll() {
        Object[] els = {3, 4, 5};
        Object[] el = {6, 7};

        Object[] res = {3, 4, 5, 6, 7};

        ImmutableLinkedList lst = new ImmutableLinkedList(els);
        ImmutableList lst_1 = lst.addAll(el);

        assertArrayEquals(res, lst_1.toArray());
    }

    public void testTestAddAll() {
        Object[] els = {3, 4, 5};
        Object[] el = {6, 7, 8};

        Object[] res = {3, 4, 6, 7, 8, 5};

        ImmutableLinkedList lst = new ImmutableLinkedList(els);
        ImmutableList lst_1 = lst.addAll(2, el);

        assertArrayEquals(res, lst_1.toArray());
    }

    public void testGet() {
        Object[] els = {3, 4, 5};

        ImmutableLinkedList lst = new ImmutableLinkedList(els);
        Object first = lst.get(1);
        Object second = lst.get(2);

        assertEquals(first, 4);
        assertEquals(second, 5);
    }

    public void testRemove() {
        Object[] els = {3, 4, 5, 6};

        Object[] first = {3, 4, 5};

        ImmutableLinkedList lst = new ImmutableLinkedList(els);
        ImmutableList lst_1 = lst.remove(3);

        assertArrayEquals(first, lst_1.toArray());
    }

    public void testSet() {
        Object[] els = {3, 4, 5, 6};

        Object[] first = {3, 4, 5, 9};

        ImmutableLinkedList lst = new ImmutableLinkedList(els);
        ImmutableList lst_1 = lst.set(3, 9);

        assertArrayEquals(first, lst_1.toArray());
    }

    public void testIndexOf() {
        Object[] els = {3, 4, 5, 6};

        Object first = 3;

        ImmutableLinkedList lst = new ImmutableLinkedList(els);
        int index = lst.indexOf(first);

        assertEquals(0, index);
    }

    public void testSize() {
        Object[] els = {3, 4, 5, 6};

        ImmutableLinkedList lst = new ImmutableLinkedList(els);
        int size = lst.size();

        assertEquals(4, size);
    }

    public void testClear() {
        Object[] els = {3, 4, 5, 6};
        ImmutableLinkedList sss = new ImmutableLinkedList();
        ImmutableLinkedList lst = new ImmutableLinkedList(els);
        ImmutableList lst_1 = lst.clear();

        assertArrayEquals(sss.toArray(), lst_1.toArray());
    }

    public void testIsEmpty() {
        Object[] els = {3, 4, 5, 6};
        ImmutableList kkk = new ImmutableLinkedList();
        ImmutableLinkedList ddd = new ImmutableLinkedList(els);
        assertEquals(ddd.isEmpty(), false);
        assertEquals(kkk.isEmpty(), true);
    }

    public void testToArray() {
        Object[] els = {3, 4, 5, 6};

        ImmutableLinkedList lst = new ImmutableLinkedList(els);

        assertArrayEquals(els, lst.toArray());
    }

    public void testAddLast() {
        Object[] els = {3, 4, 5, 6};

        Object[] first = {3, 4, 5, 6, 1};

        ImmutableLinkedList lst = new ImmutableLinkedList(els);
        ImmutableList lst_1 = lst.addLast(1);

        assertArrayEquals(first, lst_1.toArray());

    }

    public void testGetHead() {
        Object[] els = {"hello", 4, 5, 6};
        Object check = "hello";

        ImmutableLinkedList lst = new ImmutableLinkedList(els);

        assertEquals("hello", check);

    }

    public void testGetTail() {
        Object[] els = {"hello", 4, 5, 6};
        Object check = 6;

        ImmutableLinkedList lst = new ImmutableLinkedList(els);

        assertEquals(6, check);

    }

    public void testGetFirst() {
        Object[] els = {"hello", 4, 5, 6};
        Object check = "hello";

        ImmutableLinkedList lst = new ImmutableLinkedList(els);

        assertEquals(lst.getFirst(), check);
    }

    public void testGetLast() {
        Object[] els = {"hello", 4, 5, 6};
        Object check = 6;

        ImmutableLinkedList lst = new ImmutableLinkedList(els);

        assertEquals(lst.getLast(), check);
    }

    public void testRemoveFirst() {
        Object[] els = {"hello", 4, 5, 6};
        Object[] check = {4, 5, 6};

        ImmutableLinkedList lst = new ImmutableLinkedList(els);
        ImmutableList lst_1 = lst.removeFirst();

        assertArrayEquals(check, lst_1.toArray());
    }

    public void testRemoveLast() {
        Object[] els = {4, 5, 6};
        Object[] check = {4, 5};

        ImmutableLinkedList lst = new ImmutableLinkedList(els);
        ImmutableList lst_1 = lst.removeLast();

        assertArrayEquals(check, lst_1.toArray());
    }
}