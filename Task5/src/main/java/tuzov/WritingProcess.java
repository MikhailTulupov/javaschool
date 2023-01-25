package tuzov;

/**
 * An abstract process of writing
 */
public class WritingProcess implements AbstractProcessFactory{
    @Override
    public AbstractProcess createAbstractProcess() {
        return new Concatenating();
    }
}
