package tuzov;

/**
 * Process of summing abstract integers
 */
public class Summing implements AbstractProcess {
    @Override
    public AbstractType perform() {
        return new SumOfInt(77, 33);
    }
}
