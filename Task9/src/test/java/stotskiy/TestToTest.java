package stotskiy;

import org.junit.jupiter.api.Test;
import stotskiy.test.TestAfterAll;
import stotskiy.test.TestBeforeAll;
import static org.junit.jupiter.api.Assertions.*;

public class TestToTest {

    @Test
    public void testBeforeAllErr() {
        assertThrows(RuntimeException.class,() ->TestClass.start(TestBeforeAll.class));
    }

    @Test
    public void testAfterAllErr() {
        assertThrows(RuntimeException.class,() ->TestClass.start(TestAfterAll.class));
    }

    @Test
    public void testNoClassName(){
        assertThrows(ClassNotFoundException.class, () -> TestClass.start(""));
    }
}
