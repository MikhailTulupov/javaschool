package stotskiy;

/**
 * Creating (generating) a common loot box
 */

public class CommonBoxFactory implements AbstractFabricLootBox {
    @Override
    public AbstractOpenBox createAbstractOpen() {
        System.out.println("____Create Common box____\n" +
                "The chest contains:\n" +
                "1.A pile of cards\n" +
                "2.Blunt sword\n" +
                "3.Holy Blunt Sword (Epic)\n" +
                "4. 10 Oren\n" +
                "___________________________"
        );
        return new CommonBoxResult();
    }
}
