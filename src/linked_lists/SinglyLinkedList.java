package linked_lists;

import java.util.EmptyStackException;

public class SinglyLinkedList<T> {
    private Node<T> head;
    private int size;

    public SinglyLinkedList() {
        this.head = null;
        size = 0;
    }

    public SinglyLinkedList(T value) {
        this.head = new Node<>(value);
        size = 1;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0 && this.head == null;
    }

    public T valueAt(int index) {
        if(index >= size || index < 0) throw new IndexOutOfBoundsException(String.format("Index: %d, Size: %d", index, size));
        Node<T> current = this.head;
        for(int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getValue();
    }

    public void pushFront(T value) {
        Node<T> toBeAdded = new Node(value);
        toBeAdded.setNext(this.head);
        this.head = toBeAdded;
        size++;
    }

    public T popFront() {
        emptyCheck();
        T value = this.head.getValue();
        this.head = this.head.getNext();
        size--;
        return value;
    }

    public void pushBack(T value) {
        Node<T> toBeAdded = new Node(value);
        Node<T> current = this.head;
        if(current == null) {
            this.head = toBeAdded;
        } else {
            while(current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(toBeAdded);
        }
        size++;
    }

    public T popBack() {
        emptyCheck();
        Node<T> current = this.head;
        if(current.getNext() == null) return popFront();
        Node previous = null;
        while(current.getNext() != null) {
            previous = current;
            current = current.getNext();
        }
        previous.setNext(null);
        size--;
        return current.getValue();
    }

    public T front() {
        emptyCheck();
        return head.getValue();
    }

    public T back() {
        emptyCheck();
        Node<T> current = head;
        while(current.getNext() != null) {
            current = current.getNext();
        }
        return current.getValue();
    }

    private void emptyCheck() {
        if(this.size == 0 || this.head == null) throw new EmptyStackException();
    }
    private class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
            this.next = null;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
}
