package tuzov;

import tuzov.Annotations.TuAfterAll;
import tuzov.Annotations.TuBeforeAll;
import tuzov.Annotations.TuDoTest;

public class TestExample {
    @TuBeforeAll
    public void beforeAll(){
        System.out.println("Before all");
    }

    @TuAfterAll
    public void afterAll(){
        System.out.println("After all");
    }

    @TuDoTest()
    public void secondTest(){
        System.out.println("Second");
    }

    @TuDoTest(priority = 1)
    public void firstTest(){
        System.out.println("First");
    }
}
