package sazonik;

/**
 * @param <T> - datatype for class Stack
 */
@SuppressWarnings("unchecked")
public class Stack<T> {
    private final int size;
    private int stackPointer;
    private final T[] array;

    /**
     * @param size - size of stack
     */
    Stack(int size) {
        this.stackPointer = -1;
        this.size = size;
        this.array = (T[]) new Object[size];
    }

    /**
     * @param element - element to be pushed on the top
     * @throws ArrayIndexOutOfBoundsException in case of stack overflow
     */
    public void push(T element) throws ArrayIndexOutOfBoundsException {
        if (isFull()) {
            throw new ArrayIndexOutOfBoundsException("Stack is full");
        }
        array[++stackPointer] = element;
    }

    /**
     * @return last element
     * @throws ArrayIndexOutOfBoundsException in case of empty stack
     */
    public T pop() throws ArrayIndexOutOfBoundsException {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Stack is empty");
        }
        return array[stackPointer--];
    }

    /**
     * @return element <T>
     * @throws ArrayIndexOutOfBoundsException case of out of bounds
     */
    public T top() throws ArrayIndexOutOfBoundsException {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Stack is empty");
        }
        return array[stackPointer];
    }


    /**
     * @return boolean
     */
    public boolean isEmpty() {
        return stackPointer == -1;
    }

    /**
     * @return boolean
     */
    public Boolean isFull() {
        return stackPointer + 1 > size;
    }

}
