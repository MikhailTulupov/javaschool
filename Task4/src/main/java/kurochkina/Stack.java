package kurochkina;

public class Stack {
    private final int[] stackArray;
    private int top;

    public Stack(int n) {
        stackArray = new int[n];
        top = -1;
    }

    public void push(int elem) {
        stackArray[++top] = elem;
    }

    public int pop() throws ArrayIndexOutOfBoundsException {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Стек пуст");
        }
        return stackArray[top--];
    }

    public int top() throws ArrayIndexOutOfBoundsException {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Стек пуст");
        }
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }
}
