package sazonik;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class TestAbstractDude {

    @Test
    public void TestConvertHToM(){
      AbstractDude Dude = new DudeProcess();
      AbstractProcess Convert = Dude.createAbstractProcess();
      assertInstanceOf(Converting.class, Convert);
    }
}