package sazonik;

/**
 * Abstract process of Dude
 */
public class DudeProcess implements AbstractDude{

    @Override
    public AbstractProcess createAbstractProcess() { return new Converting(); }
}
