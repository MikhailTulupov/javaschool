package stotskiy;

/**
 * Creating (generating) a rare loot box
 */
public class RareBoxFactory implements AbstractFabricLootBox {
    @Override
    public AbstractOpenBox createAbstractOpen() {
        System.out.println("____Create Rare box____\n" +
                "The chest contains:\n" +
                "1.Sword of the Horseman of the Apocalypse (Legendary)\n" +
                "2.The Skull Crasher(Rare)\n" +
                "3.A sharpened sword\n" +
                "4.Ply a blunt sword\n" +
                "4.50 GOLD Orens\n" +
                "___________________________"
        );
        return new RareBoxResult(0);
    }
}