package tuzov;

/**
 * An abstract math operation
 */
public class MathOperation implements AbstractProcessFactory {
    @Override
    public AbstractProcess createAbstractProcess() {
        return new Summing();
    }
}
