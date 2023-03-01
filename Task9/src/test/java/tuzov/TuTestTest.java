package tuzov;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TuTestTest {
    static TuTest tester;

    @BeforeAll
    static void init(){
        tester = new TuTest(TestExample.class);
    }

    @Test
    public void testClazzEqu(){
        assertEquals(TestExample.class, tester.clazz);
    }

    @Test
    public void testBeforeAllEqu() throws NoSuchMethodException {
        assertEquals(TestExample.class.getMethod("beforeAll"), tester.before_all);
    }

    @Test
    public void testAfterAllEqu() throws NoSuchMethodException {
        assertEquals(TestExample.class.getMethod("afterAll"), tester.after_all);
    }

    @Test
    public void testTestQuantity() {
        assertEquals(2, tester.test_list.size());
    }

}