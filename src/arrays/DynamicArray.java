package arrays;

import java.util.EmptyStackException;

public class DynamicArray<T> {
    private final static int DEFAULT_SIZE = 16;
    private T[] array;
    private int size;

    public DynamicArray() {
        this.array = (T[])new Object[DEFAULT_SIZE];
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public int capacity() {
        return this.array.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T at(int index) {
        rangeCheck(index);
        return array[index];
    }

    public void push(T item) {
        if(size == capacity()) resize(capacity() * 2);
        array[size] = item;
        size++;
    }

    public void insert(int index, T item) {
        if(size == capacity()) resize(capacity() * 2);
        size++;
        for(int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = item;
    }

    public void prepend(T item) {
        insert(0, item);
    }

    public T pop() {
        emptyCheck();
        T value = array[size - 1];
        array[size - 1] = null;
        size--;
        if(capacity() > DEFAULT_SIZE && capacity() / 4 >= size) resize(capacity() / 2);
        return value;
    }

    public void delete(int index) {
        rangeCheck(index);
        for(int i = index; i < size; i++) {
            array[i] = array[i+1];
        }
        size--;
        if(capacity() / 4 >= size) resize(capacity() / 2);
    }

    public void remove(T item) {
        int index = find(item);
        if(index != -1) delete(index);
    }

    public int find(T item) {
        for(int i = 0; i < size; i++) {
            if(array[i] == item) return i;
        }
        return -1;
    }

    private void resize(int newCapacity) {
        T[] copy = (T[])new Object[newCapacity];
        int upperLimit = Math.min(newCapacity, capacity());
        for(int i = 0; i < upperLimit; i++) {
            copy[i] = this.array[i];
        }
        this.array = copy;
    }

    private void rangeCheck(int index) {
        try{
            if(index >= size || index < 0) throw new IndexOutOfBoundsException(String.format("Index: %d, Size: %d", index, size));
        } catch(ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    private void emptyCheck() {
        try{
            if(size == 0) throw new EmptyStackException();
        } catch(EmptyStackException e) {
            e.printStackTrace();
        }
    }
}
