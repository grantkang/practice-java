package arrays;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

class DynamicArrayTest {
    private DynamicArray<Integer> dArray;

    @Before
    public void setup() {
        dArray = new DynamicArray();
    }

    @Test
    public void testPushSizeAt() {
        assertEquals(0, dArray.size());          // Dynamic array should be empty upon construction.
        assertEquals(true, dArray.isEmpty());
        dArray.push(69);
        assertEquals(1, dArray.size());          // Size should be 1 since an element has been added.
        assertEquals(false, dArray.isEmpty());
        assertEquals(69, dArray.at(0).intValue());          // Element at index 0 should be the one pushed.
    }

    @Test
    public void testInsert() {
        dArray.push(0);
        dArray.push(1);
        dArray.push(3);
        dArray.push(4);
        dArray.insert(2, 2);
        for(int i = 0; i < dArray.size(); i++) {            // All the values should match up w/ index
            assertEquals(i, dArray.at(i).intValue());       // since we've inserted the value 2 into index 2
        }
        assertEquals(5, dArray.size());
    }

    @Test
    public void testPrepend() {
        dArray.push(1);
        dArray.push(2);
        dArray.prepend(0);
        for(int i = 0; i < dArray.size(); i++) {            // All the values should match up w/ index
            assertEquals(i, dArray.at(i).intValue());       // since we've prepended value 0 to the array
        }
    }

    @Test
    public void testPop() {
        dArray.push(69);
        assertEquals(false, dArray.isEmpty());
        assertEquals(69, dArray.pop().intValue());          // Since pop returns a value, it should be the same as the one pushed.
        assertEquals(true, dArray.isEmpty());
    }

    @Test
    public void testDelete() {
        for(int i = 0; i < 5; i++) {
            dArray.push(i);
        }
        dArray.delete(1);
        assertEquals(2, dArray.at(1).intValue());
        dArray.delete(0);
        assertEquals(2, dArray.at(0).intValue());
        assertEquals(3, dArray.size());

    }

    @Test
    public void testRemove() {
        for(int i = 0; i < 5; i++) {
            dArray.push(i+1);
        }
        dArray.remove(100);                      // Doesn't exist in the array.
        assertEquals(5, dArray.size());      // So the size should stay the same.
        dArray.remove(1);                       // Should remove the first element in the array.
        assertEquals(4, dArray.size());
        assertEquals(2, dArray.at(0).intValue());
    }

    @Test
    public void testFind() {
        for(int i = 0; i < 5; i++) {
            dArray.push(i);
        }
        for(int i = 0; i < 5; i++) {
            assertEquals(i, dArray.find(i));     // Since the added values were the same as their indices, all tests should pass
        }
    }

    @Test
    public void testResize() {
        assertEquals(16, dArray.capacity());
        for(int i = 0; i < 17; i++) {
            dArray.push(i);
        }
        assertEquals(16 * 2, dArray.capacity());
        for(int i = 0; i <= 16 / 2; i++) {
            dArray.pop();
        }
        assertEquals(8, dArray.size());
        assertEquals(16, dArray.capacity());
    }
}