package stotskiy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    Queue<Integer> queue;

    @BeforeEach
    public void init(){
        queue = new Queue<>(3);
    }

    @Test
    public void test_enqueue_full() {
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        assertThrows(ArrayIndexOutOfBoundsException.class, ()-> queue.enqueue(100));
    }

    @Test
    public void test_dequeue_empty() {
        assertThrows(ArrayIndexOutOfBoundsException.class, ()-> queue.dequeue());
    }

    @Test
    public void test_top_empty() {
        assertThrows(ArrayIndexOutOfBoundsException.class, ()-> queue.dequeue());
    }

    @Test
    public void test_top_equals_dequeue(){
        queue.enqueue(5);
        assertEquals(queue.dequeue(),queue.top());
    }

    @Test
    public void test_dequeue_order(){
        int i = 5;
        queue.enqueue(i);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(queue.dequeue(), i);
    }
}