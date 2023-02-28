package sokolov;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class QueueTest {
    Queue queue;

    @BeforeEach
    public void init() {
        queue = new Queue(3);
    }

    @Test
    public void testEnqueueFull() {
        queue.enqueue(1);
        queue.enqueue(3);
        queue.enqueue(5);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> queue.enqueue(100));
    }

    @Test
    public void testDequeueEmpty() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> queue.dequeue());
    }


    @Test
    public void testTopEqualsDequeue() {
        queue.enqueue(2);
        assertEquals(queue.getFront(), queue.dequeue());
    }

    @Test
    public void testDequeueOrder() {
        int i = 4;
        queue.enqueue(i);
        queue.enqueue(6);
        queue.enqueue(2);
        assertEquals(queue.dequeue(), i);
    }
}
