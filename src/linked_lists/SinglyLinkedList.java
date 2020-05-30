package linked_lists;

public class SinglyLinkedList<T> {
    private Node<T> head;
    private int size;

    public SinglyLinkedList() {
        head = null;
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
        Node<T> current = head;
        for(int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getValue();
    }

    public void pushFront(T value) {
        Node<T> toBeAdded = new Node(value);
        toBeAdded.setNext(head);
        this.head = toBeAdded;
        size++;
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
