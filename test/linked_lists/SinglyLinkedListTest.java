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

    @Test
    public void testInsert() {
        list = new SinglyLinkedList<>();

        list.insert(0, 0);
        list.pushBack(2);
        list.insert(1, 1);
        for(int i = 0; i < 3; i++) {
            assertEquals(i, list.valueAt(i).intValue());
        }
        assertEquals(3,list.getSize());

        list.insert(0, 1337);
        assertEquals(1337, list.front());
        assertEquals(4, list.getSize());

        list.insert(4, 1337);
        assertEquals(1337, list.back());
        assertEquals(5, list.getSize());

    }

    @Test
    public void testErase() {
        list = new SinglyLinkedList<>();

        list.pushBack(1);
        list.erase(0);
        assertEquals(0, list.getSize());
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.erase(0);
        });
        for(int i = 0; i < 3; i++) {
            list.pushBack(i);
        }
        list.erase(1);
        assertEquals(2, list.getSize());
        assertEquals(2, list.valueAt(1).intValue());

        list.erase(1);
        assertEquals(1, list.getSize());
        assertEquals(0, list.valueAt(0).intValue());

        list.pushBack(2);
        list.erase(0);
        assertEquals(1, list.getSize());
        assertEquals(2, list.valueAt(0).intValue());
    }

    @Test
    public void testValueNthFromEnd() {
        list = new SinglyLinkedList<>();
        for(int i = 0; i < 4; i++) {
            list.pushBack(i);
        }

        for(int i = 0; i < 4; i++) {
            assertEquals(3 - i, list.valueNthFromEnd(i));
        }
    }

    @Test
    public void testReverse() {
        list = new SinglyLinkedList<>();
        for(int i = 0; i < 4; i++) {
            list.pushBack(i);
        }

        list.reverse();

        for(int i = 0; i < 4; i++) {
            assertEquals(3 - i, list.valueAt(i));
        }
    }

    @Test
    public void testRemoveValue() {
        list = new SinglyLinkedList<>();
        for(int i = 0; i < 4; i++) {
            list.pushBack(i);
        }

        list.removeValue(1);

        assertEquals(2, list.valueAt(1));

        list.removeValue(0);

        assertEquals(2, list.valueAt(0));

        list.removeValue(3);
        assertEquals(2, list.valueAt(0));
        assertEquals(1, list.getSize());
    }
}