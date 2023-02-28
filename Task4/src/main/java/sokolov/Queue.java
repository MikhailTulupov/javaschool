package sokolov;

public class Queue {
    private final int[] queue;
    private final int maxSize;
    private int front = -1;
    private int rear = -1;

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        queue = new int[maxSize];
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

        int val = queue[front++];
        if (front > rear) {
            front = -1;
            rear = -1;
        }

        return val;
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

    public String str(){
        return front + "|" + rear;
    }
}
