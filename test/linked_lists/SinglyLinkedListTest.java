package linked_lists;

import org.junit.Test;

import static org.junit.Assert.*;

public class SinglyLinkedListTest {
    private SinglyLinkedList<Integer> list;

    @Test
    public void testEmptyConstructor() {
        list = new SinglyLinkedList<>();
        assertEquals(0, list.getSize());
        assertTrue(list.isEmpty());
    }

    @Test
    public void testNonEmptyConstructor() {
        list = new SinglyLinkedList<>(1337);
        assertEquals(1, list.getSize());
        assertFalse(list.isEmpty());
    }
}