package sokolov;

public class Queue {
    private final int[] queue;
    private final int maxSize;
    private int front;
    private int rear;

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        queue = new int[maxSize];
        front = -1;
        rear = -1;
    }

    public void enqueue(int elem) throws ArrayIndexOutOfBoundsException {
        if (isFull()) {
            throw new ArrayIndexOutOfBoundsException("queue is full");
        } else if(front == -1){
            front = 0;
        }
        queue[++rear] = elem;
    }

    public int dequeue() throws ArrayIndexOutOfBoundsException {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("queue is empty");
        }
        if (front > rear) {
            front = rear = -1;
        }

        return queue[front++];
    }

    public int getFront() throws ArrayIndexOutOfBoundsException {
        if (isEmpty()) throw new ArrayIndexOutOfBoundsException("queue is empty");
        return queue[front];
    }

    public boolean isFull() {
        return front == 0 && rear == queue.length - 1;
    }

    public boolean isEmpty() {
        return front == -1;
    }

}
