package sokolov;

public class Stack {
    private int mSize;
    private int[] stackArray;
    private int top;

    public Stack(int m) {
        this.mSize = m;
        stackArray = new int[mSize];
        top = -1;
    }

    public void push(int element) {
        stackArray[++top] = element;
    }

    public int pop() throws ArrayIndexOutOfBoundsException {
        if (isEmpty()){
            throw new ArrayIndexOutOfBoundsException("Стек пустой");
        }
        return stackArray[top--];
    }

    public int top() throws ArrayIndexOutOfBoundsException {
        if (isEmpty()){
            throw new ArrayIndexOutOfBoundsException("Стек пустой");
        }
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }
}
