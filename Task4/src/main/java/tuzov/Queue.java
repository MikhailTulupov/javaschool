package tuzov;


/**
 * @param <T> Queue for instances of T -
 *          O(1) for enqueue and dequeue; No empty space reorganization.
 */
@SuppressWarnings("unchecked")
public class Queue<T> {
    private final int size;
    private final T[] storage;
    private int head = -1;
    private int tail = -1;

    /**
     * @param size size of the queue. Size must be 0 or greater.
     */
    Queue (int size) {
        if (size < 0)
            throw new IllegalArgumentException("Size must be 0 and greater");
        this.size = size;
        storage = (T[]) new Object[size];
    }

    /**
     * @param elem element to be added to the queue;
     * @return  same instance of queue;
     * @throws ArrayIndexOutOfBoundsException if the queue is full.
     */
    public Queue<T> enqueue(T elem) throws ArrayIndexOutOfBoundsException{
        if (is_full())
            throw new ArrayIndexOutOfBoundsException("Queue is full");

        if (head == -1)
            head = 0;

        storage[++tail] = elem;
        return this;
    }

    /**
     * @return next element in the queue;
     * @throws ArrayIndexOutOfBoundsException if the queue is empty.
     */
    public T dequeue() throws ArrayIndexOutOfBoundsException{
        if (is_empty())
            throw new ArrayIndexOutOfBoundsException("Queue is empty");

        T val = storage[head++];

        if (head > tail){
            head = -1;
            tail = -1;
        }

        return val;
    }

    /**
     * @return next element in the queue or null if queue is empty.
     */
    public T top() {
        return !is_empty() ? storage[head] : null;
    }

    /**
     * @return boolean.
     */
    public boolean is_empty(){
        return head == -1;
    }

    /**
     * @return boolean.
     */
    public boolean is_full(){
        return tail == size - 1;
    }
}
