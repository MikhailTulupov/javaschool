package tuzov;

/**
 * Process of concatenating abstract strings
 */
public class Concatenating implements AbstractProcess {
    @Override
    public AbstractType perform() {
        return new ConcatenatedString("A", "B");
    }
}
