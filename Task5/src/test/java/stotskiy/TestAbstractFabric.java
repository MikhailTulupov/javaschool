package stotskiy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import stotskiy.*;

import java.io.IOException;

public class TestAbstractFabric {

    @Test
    public void testAllWork() throws IOException {
        AbstractFabricLootBox afrlb = new RareBoxFactory();
        afrlb.createAbstractOpen();
        RareBoxResult rare = new RareBoxResult(10);
        System.out.println(rare.result());

        afrlb = new CommonBoxFactory();
        afrlb.createAbstractOpen();
        CommonBoxResult common = new CommonBoxResult();
        System.out.println(common.result());
    }

    @Test
    public void testOpenRareLootBoxResult() {
        AbstractOpenBox rare = new RareBoxResult(10);
        assertNotNull(rare.result());
    }

    @Test
    public void testOpenCommonLootBoxResult() {
        AbstractOpenBox common = new CommonBoxResult();
        assertNotNull(common.result());
    }

}
