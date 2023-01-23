package stotskiy;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * Класс возвращающий награду пользователя за открытие
 * редкого (rare) бокса
 * */
public class RareBoxResult implements AbstractOpenBox {
    private final String rt;
    public int backspin;

    /**
     * @param backspin - значение увеличивающие шанс выпадения редкого дропа
     * */
    public RareBoxResult(int backspin){
        this.backspin = backspin;
        this.rt = getLoot(generate());
    }


    /**
     * Метод генерации сслучайного числа
     * @return возвращает число для дальнейшего выбора лута
     * */
    private int generate(){
        Random random = new Random();
        int[] number = new int[] {1,2,3,4,5};
        int[] chance = new int[] {100,100 - backspin/2,100 - backspin /3,100 - backspin/4,100- backspin/5};
        int count = IntStream.of(chance).sum();

        int index = random.nextInt(count);

        for (int i = 0; i < chance.length; i++) {
            index -=chance[i];
            if(index < 0){
                return number[i];
            }
        }
        return 5;
    }

    /**
     * Возвращает выпавщую вещь мз сундука
     * @param val - значение выпавшего рандомного числа
     * @return - вещь (лут)
     * */
    private String getLoot(int val){
       return "Вам выпало:" + switch (val){
            case 1 -> "Мечь всадника апокалипсиса";
            case 2 -> "Крушитель черепов";
            case 3 -> "Заостренный мечь";
            case 4 -> "Пылки тупой мечь";
            default -> "50 золотых оренов";
        };
    }

    @Override
    public String result() {
        return this.rt;
    }
}
