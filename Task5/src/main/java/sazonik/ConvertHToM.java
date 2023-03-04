package sazonik;

/**
 * Convert Hours to Minutes
 */
public class ConvertHToM implements AbstractType{
    Integer val;
    ConvertHToM(Integer Hours) { this.val = Hours * 60; }

    @Override
    public Object val() { return this.val; }
}
