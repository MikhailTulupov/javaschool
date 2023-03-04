package sazonik;


/**
 * Process of converting hours to minutes
 */
public class Converting implements  AbstractProcess{

    @Override
    public AbstractType perform() {return new ConvertHToM(5);}
}
