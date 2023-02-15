package stotskiy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stoskiyna.NewLinkedList;
import static org.junit.jupiter.api.Assertions.*;

class NewLinkedListTest {
    NewLinkedList<Integer> ll;

    @BeforeEach
    public void init() {
        ll = new NewLinkedList<>();
        ll.add(5);
        ll.add(6);
    }

    @Test
    public void testAdd(){
        ll.add(7);
        assertEquals(7,ll.get(2));
    }

    @Test
    public void testGetLastAndFirst(){
        assertEquals(5, ll.getFirst());
        assertEquals(6, ll.getLast());
    }

    @Test
    public void testGet(){
        ll.add(4);
        ll.add(7);
        assertEquals(4, ll.get(2));
        assertEquals(5, ll.get(0));
    }

    @Test
    public void testAddFirstAndLast(){
        ll.addFirst(9);
        assertEquals(9, ll.getFirst());
        ll.addLast(10);
        assertEquals(10,ll.getLast());
    }

    @Test
    public void testRemove(){
        ll.add(9);
        assertEquals(9, ll.get(2));
        assertTrue(ll.remove(9));
        assertNull(ll.get(2));
    }
}