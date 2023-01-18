package tuzov;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AbstractionLevelTest {
    @Test
    public void testAbstractMathOperation() {
        AbstractProcessFactory math = new MathOperation();
        AbstractProcess some_math_operation = math.createAbstractProcess();
        assertInstanceOf(Summing.class, some_math_operation);

    }

    @Test
    public void testAbstractSymbolicProcess(){
        AbstractProcessFactory writing = new WritingProcess();
        AbstractProcess some_symbolic_operation = writing.createAbstractProcess();
        assertInstanceOf(Concatenating.class, some_symbolic_operation);

    }

    @Test
    public void testMathAndWritingAreTheSame() {
        var math = new MathOperation();
        var writing = new WritingProcess();
        assertInstanceOf(AbstractProcessFactory.class, math);
        assertInstanceOf(AbstractProcessFactory.class, writing);

    }

    @Test
    public void testAllTypesAreAbstract() {
        SumOfInt sumof10and20 = new SumOfInt(10, 20);
        ConcatenatedString helloworld = new ConcatenatedString("hello", "world");
        assertInstanceOf(AbstractType.class, sumof10and20);
        assertInstanceOf(AbstractType.class, helloworld);

    }

}