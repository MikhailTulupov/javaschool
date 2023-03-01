package stotskiy.test;

import stotskiy.Anotation.DoBeforeAll;

public class TestBeforeAll {

    @DoBeforeAll
    public void testBeforeAllErr1(){
        System.out.println("I am first");
    }


    @DoBeforeAll
    public void testBeforeAllErr2(){
        System.out.println("I am first");
    }
}
