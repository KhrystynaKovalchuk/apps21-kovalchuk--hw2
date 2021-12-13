package ua.edu.ucu.collections.immutable;

import junit.framework.TestCase;

import static org.junit.Assert.assertArrayEquals;

public class ImmutableArrayListTest extends TestCase {

    public void testAdd() {
        Object[] els = {4, 5, 6};
        Object[] check = {4, 5, 6, 8};

        ImmutableLinkedList lst = new ImmutableLinkedList(els);
        ImmutableList lst_1 = lst.add(8);

        assertArrayEquals(check, lst_1.toArray());
    }

    public void testTestAdd() {
        Object[] els = {4, 5, 6};
        Object[] check = {4, 5, 8, 6};

        ImmutableLinkedList lst = new ImmutableLinkedList(els);
        ImmutableList lst_1 = lst.add(2,8);

        assertArrayEquals(check, lst_1.toArray());
    }

    public void testAddAll() {
        Object[] els = {4, 5, 6};
        Object[] check = {4, 5, 6, 8, 2};
        Object[] add = {8, 2};

        ImmutableLinkedList lst = new ImmutableLinkedList(els);
        ImmutableList lst_1 = lst.addAll(add);

        assertArrayEquals(check, lst_1.toArray());
    }

    public void testGet() {
        Object[] test = {1,2,3,};
        ImmutableArrayList lst = new ImmutableArrayList(test);
        Object to_get = lst.get(1);

        assertEquals(to_get, 2);
    }

    public void testSet() {
        Object[] test = {1,2,3};
        Object[] check = {1,2,"ji"};
        ImmutableArrayList lis = new ImmutableArrayList(test);
        Object to_get = lis.set(2, "ji");

        assertArrayEquals(check, ((ImmutableList) to_get).toArray());
    }

    public void testIndexOf() {
        Object[] test = {1,2,3};
        ImmutableArrayList lis = new ImmutableArrayList(test);
        int to_get = lis.indexOf(2);

        assertEquals(to_get, 1);
    }

    public void testSize() {
        Object[] test = {1,2,3};
        ImmutableArrayList lis = new ImmutableArrayList(test);
        int jjj = lis.size();

        assertEquals(jjj, 3);
    }

    public void testClear() {
        Object[] ts = {1,2,3};
        ImmutableList ch = new ImmutableArrayList();
        ImmutableArrayList lis = new ImmutableArrayList(ts);
        ImmutableList get = lis.clear();

        assertArrayEquals(ch.toArray(), get.toArray());
    }

    public void testIsEmpty() {
        Object[] ts = {1,2,3};
        ImmutableList ch = new ImmutableArrayList();
        ImmutableArrayList lis = new ImmutableArrayList(ts);

        assertEquals(ch.isEmpty(), true);
        assertEquals(lis.isEmpty(), false);
    }

    public void testToArray() {
        Object[] ddd = {1,2,3};
        ImmutableArrayList lis = new ImmutableArrayList(ddd);

        assertArrayEquals(ddd, lis.toArray());
    }
}