package linked_lists;

import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

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

    @Test
    public void testPushFront() {
        list = new SinglyLinkedList<>();
        for(int i = 4; i >= 0; i--) {
            list.pushFront(i);
        }
        for(int i = 0; i < 5; i++) {
            assertEquals(i, list.valueAt(i).intValue());
        }
        assertEquals(5, list.getSize());
    }

    @Test void testPopFront() {
        list = new SinglyLinkedList<>();
        for(int i = 4; i >= 0; i--) {
            list.pushFront(i);
        }
        for(int i = 0; i < 5; i++) {
            assertEquals(i, list.popFront().intValue());
        }
        assertEquals(0, list.getSize());
        assertThrows(EmptyStackException.class, () -> {
            list.popFront();
        });
    }

    @Test
    public void testPushBack() {
        list = new SinglyLinkedList<>();
        for(int i = 0; i < 5; i++) {
            list.pushBack(i);
        }
        for(int i = 0; i < 5; i++) {
            assertEquals(i, list.valueAt(i).intValue());
        }
        assertEquals(5, list.getSize());
    }

    @Test
    public void testPopBack() {
        list = new SinglyLinkedList<>();
        for(int i = 0; i < 5; i++) {
            list.pushBack(i);
        }
        for(int i = 4; i >= 0; i--) {
            assertEquals(i, list.popBack().intValue());
        }
        assertEquals(0, list.getSize());
        assertThrows(EmptyStackException.class, () -> {
            list.popBack();
        });
    }

    @Test
    public void testFront() {
        list = new SinglyLinkedList<>();
        assertThrows(EmptyStackException.class, () -> {
            list.front();
        });
        for(int i = 0; i < 3; i++) {
            list.pushBack(i);
        }
        assertEquals(0, list.front().intValue());
    }

    @Test
    public void testBack() {
        list = new SinglyLinkedList<>();
        assertThrows(EmptyStackException.class, () -> {
            list.back();
        });
        for(int i = 0; i < 3; i++) {
            list.pushBack(i);
        }
        assertEquals(2, list.back().intValue());
    }

}