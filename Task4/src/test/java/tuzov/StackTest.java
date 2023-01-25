package tuzov;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    Stack<Integer> stack;

    @BeforeEach
    public void createStack(){
        stack = new Stack<>(2);
    }

    @Test
    public void testPushOverflow(){
        stack.push(1);
        stack.push(2);

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> stack.push(3));
    }

    @Test
    public void testPopEmpty(){
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> stack.pop());
    }

    @Test
    public void testMultiPush(){
        stack.push(1).push(2);

        int num2 = stack.pop();
        int num1 = stack.pop();

        assertEquals(2, num2);
        assertEquals(1, num1);
    }

    @Test
    public void testPopOrder(){
        int num1 = 1;
        int num2 = 2;

        stack.push(num1).push(num2);

        assertEquals(num2, stack.pop());
        assertEquals(num1, stack.pop());
    }

    @Test
    public void testTopOfEmptyStack(){
        assertNull(stack.top());
    }

    @Test
    public void testTopEquPop(){
        stack.push(10);
        int top_elem = stack.top();
        int pop_elem = stack.pop();

        assertEquals(top_elem, pop_elem);
    }

    @Test
    public void testEmptyStack(){
        assertTrue(stack.isEmpty());

        stack.push(1);
        stack.pop();

        assertTrue(stack.isEmpty());
    }

    @Test
    public void testZeroSizeStack(){
        Stack<Object> zStack = new Stack<>(0);
        assertTrue(zStack.isEmpty());
        assertNull(zStack.top());
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> zStack.push(10));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> zStack.pop());
    }
}