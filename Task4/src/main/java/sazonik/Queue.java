package sazonik;

/**
 * @param <T> - datatype for class Queue
 */
@SuppressWarnings("unchecked")
public final class Queue<T> {
    private final int size;
    private final T[] array;
    private int start = -1, end = -1;

    /**
     *
     * @param size - size of queue
     */
    Queue(int size) {
        this.size = size;
        this.array = (T[]) new Object[size];
    }

    /**
     * @param element - element to be added to the queue
     * @throws ArrayIndexOutOfBoundsException if the queue is full
     */
    public void enqueue(T element) throws ArrayIndexOutOfBoundsException {
        if (isFull()) {
            throw new ArrayIndexOutOfBoundsException("Queue is full");
        } else if (start == -1) {
            start = 0;
        }
        array[++end] = element;
    }

    /**
     * @return next element in the queue or null if queue is empty.
     */
    public T top() {
        return !isEmpty() ? array[start] : null;
    }

    /**
     * @return next element in the queue
     * @throws ArrayIndexOutOfBoundsException if the queue is empty
     */
    public T dequeue() throws ArrayIndexOutOfBoundsException {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Queue is empty");
        }
        if (start > end)
            start = end = -1;

        return array[start++];
    }

    /**
     * @return boolean
     */
    public boolean isEmpty() {
        return start == -1;
    }

    /**
     * @return boolean
     */
    public boolean isFull() {
        return start == 0 && end == array.length - 1;
    }
}

