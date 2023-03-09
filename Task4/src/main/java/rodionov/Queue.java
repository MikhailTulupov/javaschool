package rodionov;

public class Queue<T> {
    private final int size;
    private final T[] array;
    private int start = -1, end = -1;


    Queue(int size) {
        this.size = size;
        this.array = (T[]) new Object[size];
    }


    public void enqueue(T element) throws ArrayIndexOutOfBoundsException {
        if (isFull()) {
            throw new ArrayIndexOutOfBoundsException("Queue is full");
        } else if (start == -1) {
            start = 0;
        }
        array[++end] = element;
    }


    public T dequeue() throws ArrayIndexOutOfBoundsException {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Queue is empty");
        }
        if (start > end)
            start = end = -1;

        return array[start++];
    }


    public T top() throws ArrayIndexOutOfBoundsException {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Queue is empty");
        }
        return array[start];
    }


    public boolean isEmpty() {
        return start == -1;
    }


    public boolean isFull() {
        return start == 0 && end == array.length - 1;
    }
}
