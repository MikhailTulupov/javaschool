package stotskiy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    Stack<Integer> stack;

    @BeforeEach
    public void init(){
        stack =  new Stack<>(3);
    }

    @Test
    public void test_push_overflow() {
        stack.push(2);
        stack.push(3);
        stack.push(4);
        assertThrows(ArrayIndexOutOfBoundsException.class,()-> stack.push(5));
    }

    @Test
    public void test_pop_empty() {
        assertThrows(ArrayIndexOutOfBoundsException.class, ()-> stack.pop());
    }

    @Test
    public void test_top_empty() {
        assertThrows(ArrayIndexOutOfBoundsException.class, ()-> stack.top());
    }

    @Test
    public void test_top_equals_pop(){
        stack.push(5);
        assertEquals(stack.top(),stack.pop());
    }
}