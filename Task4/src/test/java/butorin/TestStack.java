package butorin;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestStack {
    Stack stack;

    @BeforeEach
    public void init() {
        stack = new Stack(6);
    }

    @Test
    public void testPush() {
        stack.push(5);
        stack.push(4);
        stack.push(20);
        stack.push(99);
        stack.push(34);
        stack.push(6);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> stack.push(10));
    }

    @Test
    public void testPopEmpty() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> stack.pop());
    }

    @Test
    public void testTopEmpty() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> stack.top());
    }

    @Test
    public void testTopEqualsPop() {
        stack.push(22);
        assertEquals(stack.top(), stack.pop());
    }

}
