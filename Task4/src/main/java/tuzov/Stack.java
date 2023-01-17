package tuzov;


/**
 * @param <T> Stack for instances of T.
 */
@SuppressWarnings("unchecked")
public class Stack<T> {
    private final int size;
    private final T[] storage;
    private int pointer = -1;

    /**
     * @param size size of the stack. Size must be 0 or greater.
     */
    Stack(int size) throws IllegalArgumentException {
        if (size < 0)
            throw new IllegalArgumentException("Size must be 0 and greater");
        this.size = size;
        storage = (T[]) new Object[size];
    }

    /**
     * @param elem element to be pushed on the top of the stack;
     * @return same instance of stack;
     * @throws ArrayIndexOutOfBoundsException in case of stack overflow.
     */
    public Stack<T> push(T elem) throws ArrayIndexOutOfBoundsException {
        if (pointer + 1 >= size)
            throw new ArrayIndexOutOfBoundsException("Stack overflow");
        storage[++pointer] = elem;
        return this;
    }

    /**
     * @return element at the top of the stack;
     * @throws ArrayIndexOutOfBoundsException in case of empty stack.
     */
    public T pop() throws ArrayIndexOutOfBoundsException {
        if (is_empty())
            throw new ArrayIndexOutOfBoundsException("Stack is empty");
        return storage[pointer--];
    }

    /**
     * @return element at the top of the stack or null if stack is empty.
     */
    public T top() {
        return !is_empty() ? storage[pointer] : null;
    }

    /**
     * @return boolean.
     */
    public boolean is_empty() {
        return pointer == -1;
    }
}
