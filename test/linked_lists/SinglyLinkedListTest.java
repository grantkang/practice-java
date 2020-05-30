package linked_lists;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {
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

    @Test
    public void testValueAt() {
        list = new SinglyLinkedList<>(1337);
        assertEquals(1337, list.valueAt(0).intValue());
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.valueAt(1);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.valueAt(-1);
        });

    }
}