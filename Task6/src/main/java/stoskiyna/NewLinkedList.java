package stoskiyna;

/**
 * Задание Task6 - собственная реализация LinkedList
 * Работа класса основываеться на узлах.
 *
 * @param <E> любой тип данных, который будет хранить лист
 */
public class NewLinkedList<E>
        implements NLListInter<E> {
    private int size = 0;

    Node<E> last;
    Node<E> first;

    /**
     * Внутренний класс реализующий узел
     */
    private class Node<E> {
        E data;
        Node<E> previous;
        Node<E> next;

        /**
         * @param previous ссылка на предыдущий узел
         * @param next     ссылка на следующий узел
         * @param data     данные хранимые в узле
         */
        Node(Node<E> previous, Node<E> next, E data) {
            this.data = data;
            this.next = next;
            this.previous = previous;
        }
    }

    /**
     * @return возвращает размер LinkedList
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Метод добавляющий элемент введенный пользователем
     **/
    @Override
    public void add(E element) {
        addLast(element);
    }

    /**
     * Метод добавляющий элемент введенный пользователем в начало LinkedList
     **/
    @Override
    public void addFirst(E element) {
        Node<E> firstNew = first;
        Node<E> node = new Node<>(null, firstNew, element);
        first = node;
        if (firstNew == null)
            this.last = node;
        else
            this.first.previous = node;
        size++;
    }

    /**
     * Метод добавляющий элемент введенный пользователем в конец LinkedList
     **/
    @Override
    public void addLast(E element) {
        Node<E> lastNew = last;
        Node<E> node = new Node<>(lastNew, null, element);
        last = node;
        if (lastNew == null)
            this.first = node;
        else
            lastNew.next = node;
        size++;
    }

    /**
     * Метод поиска элемента по индексу
     *
     * @param index индекс искомого элемента
     * @return найденный элемент, иначе null
     */
    @Override
    public E get(int index) {
        int count = 0;
        Node<E> currentNode = first;
        while (currentNode != null && count != index) {
            currentNode = currentNode.next;
            count++;
        }

        if (currentNode == null) {
            return null;
        }
        return currentNode.data;
    }

    /**
     * Метод озвращающий первый(начальный) элемент в списке
     *
     * @return найденный элемент, иначе null
     */
    @Override
    public E getFirst() {
        Node<E> f = first;
        if (f == null)
            return null;
        return f.data;
    }

    /**
     * Метод озвращающий полседний(конечный) элемент в списке
     *
     * @return найденный элемент, иначе null
     */
    @Override
    public E getLast() {
        Node<E> l = last;
        if (l == null)
            return null;
        return l.data;
    }

    /**
     * Метод удаляющий элемент по его значению
     *
     * @return истина если элемени есть и он удален, ложь в противоположно случае
     */
    @Override
    public boolean remove(E element) {
        Node<E> firstNew = first;
        while (firstNew != null) {
            if (firstNew.data == element) {

                if (firstNew.previous == null) {
                    first = firstNew.next;
                } else {
                    firstNew.previous.next = firstNew.next;
                    firstNew.previous = null;
                }

                if (firstNew.next == null) {
                    last = firstNew.previous;
                } else {
                    firstNew.next.previous = firstNew.previous;
                    firstNew.next = null;
                }
                firstNew.data = null;
                size--;
                return true;
            }
            firstNew = firstNew.next;
        }
        return false;
    }
}
