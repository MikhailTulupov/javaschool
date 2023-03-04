package sazonik;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    LinkedList<Integer> list;

    @BeforeEach
    public void init(){
        list = new LinkedList<>();
    }

    @Test
    public void addLast(){
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        assertEquals(3, list.get(2));
        assertEquals(2, list.get(1));
        assertEquals(1, list.get(0));
    }

    @Test
    public void addFirst(){
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    @Test
    public void removeOneNode(){
        list.addLast(1);
        list.remove(0);
        assertNull(list.getFirst());
        assertNull(list.getLast());
    }

    @Test
    public void removeLastNode(){
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        int mid = list.get(1);
        list.remove(2);
        assertEquals(mid, list.getLast());
    }

    @Test
    public void removeFirstNode(){
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        int mid = list.get(1);
        list.remove(0);
        assertEquals(mid, list.getFirst());
    }

    @Test
    public void addOneNode(){
        list.add(1, 1);
        assertEquals(1, list.get(0));
        assertNull(list.get(1));
    }

    @Test
    public void getLast(){
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        assertEquals(1, list.getFirst());
    }

    @Test
    public void getFirst(){
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        assertEquals(3, list.getLast());
    }
}