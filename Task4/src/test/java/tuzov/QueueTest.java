package tuzov;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    Queue<Integer> queue;

    @BeforeEach
    public void createStack(){
        queue = new Queue<>(3);
    }

    @Test
    public void testEnqueueOverflow(){
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> queue.enqueue(4));
    }

    @Test
    public void testDequeueEmpty(){
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> queue.dequeue());
    }

    @Test
    public void testMultiEnqueue(){
        queue.enqueue(1).enqueue(2);

        int num1 = queue.dequeue();
        int num2 = queue.dequeue();

        assertEquals(1, num1);
        assertEquals(2, num2);
    }

    @Test
    public void testQueueOrder(){
        int num1 = 1;
        int num2 = 2;
        int num3 = 3;

        queue.enqueue(num1).enqueue(num2).enqueue(num3);

        assertEquals(num1, queue.dequeue());
        assertEquals(num2, queue.dequeue());
        assertEquals(num3, queue.dequeue());
    }

    @Test
    public void testTopEquDequeue(){
        queue.enqueue(10).enqueue(20);
        int top_elem = queue.top();
        int deq_elem = queue.dequeue();

        assertEquals(top_elem, deq_elem);
    }

    @Test
    public void testEmptyQueue(){
        assertTrue(queue.is_empty());

        queue.enqueue(10).enqueue(20);
        queue.dequeue();
        queue.dequeue();

        assertTrue(queue.is_empty());
    }

    @Test
    public void testFullQueue(){
        queue.enqueue(10).enqueue(20).enqueue(30);

        assertTrue(queue.is_full());
    }

    @Test
    public void testZeroQueue(){
        Queue<Object> zQueue = new Queue<>(0);
        assertTrue(zQueue.is_full());
        assertTrue(zQueue.is_empty());
        assertNull(zQueue.top());
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> zQueue.enqueue(10));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> zQueue.dequeue());

    }
}