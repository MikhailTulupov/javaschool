package tuzov;

/**
 * Represents the atomic concatenated string
 */
public class ConcatenatedString implements AbstractType{
    String val;
    ConcatenatedString(String str1, String str2){
        this.val = str1 + str2;
    }

    @Override
    public Object val() {
        return this.val;
    }
}
