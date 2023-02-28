package sokolov;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StackTest {
    Stack stack;

    @BeforeEach
    public void init() {
        stack = new Stack(5);
    }

    @Test
    public void testPush() {
        stack.push(10);
        stack.push(11);
        stack.push(15);
        stack.push(120);
        stack.push(1);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> stack.push(12));
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
    public void testPopEqualsPop() {
        stack.push(22);
        assertEquals(stack.top(), stack.pop());
    }
}
