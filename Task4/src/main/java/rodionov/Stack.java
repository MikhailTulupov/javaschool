package rodionov;

@SuppressWarnings("unchecked")
public class Stack<T> {
    private final int size;
    private int stackPointer;
    private final T[] array;


    Stack(int size) {
        this.stackPointer = -1;
        this.size = size;
        this.array = (T[]) new Object[size];
    }


    public void push(T element) throws ArrayIndexOutOfBoundsException {
        if (isFull()) {
            throw new ArrayIndexOutOfBoundsException("Stack is full");
        }
        array[++stackPointer] = element;
    }


    public T pop() throws ArrayIndexOutOfBoundsException {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Stack is empty");
        }
        return array[stackPointer--];
    }


    public T top() throws ArrayIndexOutOfBoundsException {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Stack is empty");
        }
        return array[stackPointer];
    }


    public boolean isEmpty() {
        return stackPointer == -1;
    }


    public Boolean isFull() {
        return stackPointer + 1 > size;
    }
}

