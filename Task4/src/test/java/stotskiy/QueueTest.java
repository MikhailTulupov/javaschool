package stotskiy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    Queue<Integer> queue;

    @BeforeEach
    public void init() {
        queue = new Queue<>(3);
    }

    @Test
    public void testEnqueueFull() {
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> queue.enqueue(100));
    }

    @Test
    public void testDequeueEmpty() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> queue.dequeue());
    }

    @Test
    public void testTopEmpty() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> queue.dequeue());
    }

    @Test
    public void testTopEqualsDequeue() {
        queue.enqueue(5);
        assertEquals(queue.top(), queue.dequeue());
    }

    @Test
    public void testDequeueOrder() {
        int i = 5;
        queue.enqueue(i);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(queue.dequeue(), i);
    }
}