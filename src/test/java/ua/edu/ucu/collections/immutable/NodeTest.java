package ua.edu.ucu.collections.immutable;

import junit.framework.TestCase;

public class NodeTest extends TestCase {

    public void testGetPrevious() {
        Node node = new Node();
        node.setPrevious(null);

        assertEquals(node.getPrevious(), null);
    }

    public void testGetValue() {
        Node node = new Node();
        node.setValue("hdflsjfsj");

        assertEquals(node.getValue(),"hdflsjfsj");
    }
}