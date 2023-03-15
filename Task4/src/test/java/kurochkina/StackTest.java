package kurochkina;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StackTest {
    Stack stack;

    @BeforeEach
    public void init() {
        stack = new Stack(6);
    }

    @Test
    public void testPush() {
        stack.push(4);
        stack.push(3);
        stack.push(5);
        stack.push(66);
        stack.push(22);
        stack.push(10);
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
