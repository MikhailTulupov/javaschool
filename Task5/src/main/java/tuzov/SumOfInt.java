package tuzov;

/**
 * Atomic data type of the sum of 2 integers
 */
public class SumOfInt implements AbstractType{
    int sum;
    SumOfInt(int a, int b){
        this.sum = a + b;
    }

    public Object val(){
        return this.sum;
    }
}
