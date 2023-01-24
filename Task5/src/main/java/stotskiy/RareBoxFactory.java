package stotskiy;
/**
 * Создание (генерация) редкого лутбокса
 * */
public class RareBoxFactory implements AbstractFabricLootBox{
    @Override
    public AbstractOpenBox createAbstractOpen() {
        System.out.println("____Create Rare box____\n" +
                "В сундуке содержиться:\n" +
                "1.Мечь всадника апокалипсиса (Legendary)\n" +
                "2.Крушитель черепов(Rare)\n" +
                "3.Заостренный мечь\n" +
                "4.Пылки тупой мечь\n" +
                "4.50 золотых оренов\n" +
                "___________________________"
        );
        return new RareBoxResult(0);
    }
}