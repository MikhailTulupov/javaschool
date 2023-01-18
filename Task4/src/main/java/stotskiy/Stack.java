package stotskiy;

/**
 * @param <T> - тип данных с которым работает Stack
 */
@SuppressWarnings("unchecked")
public class Stack<T>{
    private final int size;
    private int stackPointer;
    private final T[] array;

    /**
     * Конструктор класса Stack
     * @param size - размер массива (Стека)
     */
    Stack(int size){
        this.stackPointer = -1;
        this.size = size;
        this.array =  (T[]) new Object[size];
    }

    /**
     * Метод помещает элемнеты в стек
     * @param element, элемент который должен будет помещен в стек
     * @throws ArrayIndexOutOfBoundsException - обрабатываем исключение, на отрицательное
     * или пустое число в структуре
     */
    public void push(T element) throws ArrayIndexOutOfBoundsException  {
       if(isFull()){
           throw new ArrayIndexOutOfBoundsException("Stack is full");
       }
        array[++stackPointer] = element;
    }

    /**
     * Метод возвращает верхний элемент после удаления
     * @return последний элемет стека и уменьщает
     * @throws ArrayIndexOutOfBoundsException - обрабатываем исключение, на отрицательное
     * или пустое число в структуре
     */
    public T pop() throws ArrayIndexOutOfBoundsException {
        if(isEmpty()){
            throw new ArrayIndexOutOfBoundsException("Stack is empty");
        }
        return array[stackPointer--];
    }

    /**
     * Метод возвращает верхний элемент очереди
     * @return элемент тип <T>.
     * @throws ArrayIndexOutOfBoundsException  обрабатываем исключение, на отрицательное
     * или пустое число в структуре.
     */
    public T top()throws ArrayIndexOutOfBoundsException{
        if(isEmpty()){
            throw new ArrayIndexOutOfBoundsException("Stack is empty");
        }
        return array[stackPointer];
    }

    /**
     * @return вернет true, если указатель имеет значение-1
     */
    public boolean isEmpty(){
        return stackPointer == -1;
    }

    /**
      @return вернет true, если указатель будет больше размера массива
     */
    public Boolean isFull(){
        return  stackPointer + 1 > size;
    }

}
