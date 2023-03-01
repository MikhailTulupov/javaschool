package stotskiy.test;

import stotskiy.Anotation.DoAfterAll;
import stotskiy.Anotation.DoBeforeAll;

public class TestAfterAll {

    @DoAfterAll
    public void testAfterAllErr1(){
        System.out.println("Goooo");
    }

    @DoAfterAll
    public void testAfterAllErr2(){
        System.out.println("Goooo");
    }
}
