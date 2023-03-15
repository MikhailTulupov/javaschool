package kurochkina;

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
        System.out.println(queue.isFull());
        queue.dequeue();
        System.out.println(queue.str());
        queue.dequeue();
        System.out.println(queue.str());
        queue.dequeue();
        System.out.println(queue.str());
        System.out.println(queue.isEmpty());
    }

    @Test
    public void testDequeueEmpty() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> queue.dequeue());
    }

    @Test
    public void testDequeueFull() {
        queue.enqueue(4);
        assertEquals(queue.getFront(), queue.dequeue());
    }

    @Test
    public void testDequeueOrder() {
        int i = 7;
        queue.enqueue(i);
        queue.enqueue(2);
        queue.enqueue(12);
        assertEquals(queue.dequeue(), i);
    }
}
