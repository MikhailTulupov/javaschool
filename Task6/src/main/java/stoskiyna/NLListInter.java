package stoskiyna;

public interface NLListInter<E> {

    void add(E element);

    void addFirst(E element);

    void addLast(E element);

    E get(int index);

    E getFirst();

    E getLast();

    boolean remove(E element);
}
