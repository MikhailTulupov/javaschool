package tuzov;

import tuzov.Annotations.TuAfterAll;
import tuzov.Annotations.TuBeforeAll;
import tuzov.Annotations.TuDoTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Stream;

/**
 * Custom Test class which only implements running tests, not asserting
 * All methods having @TuDoTest annotation are considered to be test cases
 */
public class TuTest {
    public Class<?> clazz;
    public Method before_all, after_all;
    public List<Method> test_list;

    /**
     * @param clazz Class to be tested
     */
    public TuTest(Class<?> clazz) {
        this.clazz = clazz;
        this.collectMethods();
    }

    /**
     * @param name_class name of the class to be tested
     * @throws ClassNotFoundException is given class was not found
     */
    public TuTest(String name_class) throws ClassNotFoundException {
        try {
            this.clazz = Class.forName(name_class);
        }
        catch (ClassNotFoundException e) {
            System.out.println("Class = " + name_class + ".class not found");
            e.printStackTrace();
            throw e;
        }

        this.collectMethods();
    }

    {
        before_all = null;
        after_all = null;
    }

    private void collectMethods(){
        int before_count = 0;
        int after_count = 0;

        Map<Method, Integer> tests = new HashMap<>();
        for (Method m : clazz.getDeclaredMethods()) {
            if (m.isAnnotationPresent(TuDoTest.class)) {
                tests.put(m, m.getAnnotation(TuDoTest.class).priority());
            }

            if (m.isAnnotationPresent(TuBeforeAll.class)) {
                before_count++;
                before_all = m;
            }

            if (m.isAnnotationPresent(TuAfterAll.class)) {
                after_count++;
                after_all = m;
            }

            if (before_count > 1)
                throw new RuntimeException("Using more than one @DoBeforeAll annotation is prohibited");
            if (after_count > 1)
                throw new RuntimeException("Using more than one @DoAfterAll annotation is prohibited");

            this.test_list = tests
                    .entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .flatMap(e -> Stream.of(e.getKey()))
                    .toList();
        }
    }

    /**
     * Entry point
     */
    public void start() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        if (before_all != null)
            before_all.invoke(clazz.getConstructor().newInstance());

        for (Method m : test_list) {
            m.invoke(clazz.getConstructor().newInstance());
        }

        if (after_all != null)
            after_all.invoke(clazz.getConstructor().newInstance());
    }
}