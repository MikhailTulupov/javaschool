package stotskiy;

import stotskiy.Anotation.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * This class works as an analog of JUnit
 */
public class TestClass {
    /**
     * @param clazz class to be test
     */
    public static void start(Class<?> clazz) throws NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        int before_count = 0;
        int afterCount = 0;
        Map<Method, Integer> tests = new HashMap<>();
        Method before_all = null;
        Method after_all = null;
        for (Method m : clazz.getDeclaredMethods()) {
            if (m.isAnnotationPresent(DoTest.class)) {
                tests.put(m, m.getAnnotation(DoTest.class).order());
            }

            if (m.isAnnotationPresent(DoBeforeAll.class)) {
                before_count++;
                before_all = m;
            }

            if (m.isAnnotationPresent(DoAfterAll.class)) {
                afterCount++;
                after_all = m;
            }
        }

        if (before_count > 1)
            throw new RuntimeException("Using more than one @DoBeforeAll annotation is prohibited");
        if (afterCount > 1)
            throw new RuntimeException("Using more than one @DoAfterAll annotation is prohibited");

        var testsList = tests.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .flatMap(e -> Stream.of(e.getKey()))
                .collect(Collectors.toList());

        if (before_all != null)
            before_all.invoke(clazz.getConstructor().newInstance());

        for (Method m : testsList) {
            try {
                m.invoke(clazz.getConstructor().newInstance());
            } catch (IllegalAccessException e) {
                System.out.println(e);
            }
        }

        if (after_all != null)
            after_all.invoke(clazz.getConstructor().newInstance());
    }

    /**
     * @param nameClass name of class to be test
     */
    public static void start(String nameClass) throws ClassNotFoundException {
        try {
            Class<?> clazz = Class.forName(nameClass);
            TestClass.start(clazz);
        } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException | InstantiationException e) {
            System.out.println("Class = " + nameClass + ".class not found");
            e.printStackTrace();
        }
    }
}


