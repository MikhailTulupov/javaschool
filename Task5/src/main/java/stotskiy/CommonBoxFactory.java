package stotskiy;
/**
 * Создание (генерация) обычного лутбокса
 * */
public class CommonBoxFactory implements AbstractFabricLootBox{
    @Override
    public AbstractOpenBox createAbstractOpen() {
        System.out.println("____Create Common box____\n" +
                "В сундуке содержиться:\n" +
                "1.Кипа карт\n" +
                "2.Тупой сай\n" +
                "3.Святой тупой мечь (Epic)\n" +
                "4. 10 оренов\n" +
                "___________________________"
        );
        return new CommonBoxResult();
    }
}
