package stotskiy;

/**
 * Класс возвращающий награду пользователя за открытие
 * обычного (common) бокса
 * */
public class CommonBoxResult implements AbstractOpenBox {
    private final String st;

    public CommonBoxResult() {
        int max = 450;
        int min = -100;
        this.st = getLoot((int) (Math.random() * ((max - min) + 1)) + min);
    }

    /**
     * Возвращает выпавщую вещь мз сундука
     * @param value - значение диапазона
     * @return - вещь (лут)
     */
    private String getLoot(int value) {
        return "Вам выпало:" + switch (value / 150) {
            case 0 -> "Кипа карт";
            case 1 -> "Тупой сай";
            case 2 -> "Святой тупой мечь";
            default -> "10 золотых оренов";
        };
    }

    @Override
    public String result() {
        return this.st;
    }
}
