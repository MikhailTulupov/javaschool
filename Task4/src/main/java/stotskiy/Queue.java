package stotskiy;

/**
 * @param <T> - тип данных с которым работает Queue (очереди)
 */
public class Queue<T> {
    private final int size;
    private final T[] array;
    private int start = -1, end = -1;

    /**
     * Конструктор класса Queue
     *
     * @param size - размер массива (Стека)
     */
    Queue(int size) {
        this.size = size;
        this.array = (T[]) new Object[size];
    }

    /**
     * Метод добавляет в конец очереди элемент введенный пользователем.
     *
     * @param element - элемент вводимый пользователем в конец очереди.
     * @throws ArrayIndexOutOfBoundsException - обрабатываем исключение, на отрицательное
     *                                        или пустое число в структуре.
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
     * Метод возвращающий первый элемнет из очереди и удаляет его удаляет его из начала.
     *
     * @return элемент тип <T>.
     * @throws ArrayIndexOutOfBoundsException - обрабатываем исключение, на отрицательное
     *                                        или пустое число в структуре.
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
     * Метод возвращает первый элемент из очереди, без удаления
     *
     * @return элемент тип <T>.
     * @throws ArrayIndexOutOfBoundsException - обрабатываем исключение, на отрицательное
     *                                        или пустое число в структуре.
     */
    public T top() throws ArrayIndexOutOfBoundsException {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Queue is empty");
        }
        return array[start];
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
