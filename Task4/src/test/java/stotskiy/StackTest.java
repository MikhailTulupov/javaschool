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
    public void testPushOverflow() {
        stack.push(2);
        stack.push(3);
        stack.push(4);
        assertThrows(ArrayIndexOutOfBoundsException.class,()-> stack.push(5));
    }

    @Test
    public void testPopEmpty() {
        assertThrows(ArrayIndexOutOfBoundsException.class, ()-> stack.pop());
    }

    @Test
    public void testTopEmpty() {
        assertThrows(ArrayIndexOutOfBoundsException.class, ()-> stack.top());
    }

    @Test
    public void testTopEqualsPop(){
        stack.push(5);
        assertEquals(stack.top(),stack.pop());
    }
}