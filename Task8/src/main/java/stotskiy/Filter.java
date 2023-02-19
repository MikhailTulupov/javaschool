package stotskiy;

import java.util.function.Function;

/**
 * Its own version of the functional interface for filtering, works in the likeness of {@link Function}
 */
@FunctionalInterface
public interface Filter {
    /**
     * @param o the function argument
     * @return the function result
     */
    boolean apply(Object o);
}
