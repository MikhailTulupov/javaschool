package kurochkina;

import kurochkina.KnightRider.Knight;
import kurochkina.KnightRider.KnightAction;

public class KnightSatActionFactory {
    public static void main(String[] args) {
        ActionFactory actionFactory = new KnightAction();
        Rider rider = actionFactory.getRider();
        Action action = actionFactory.getAction();
        Horse horse = actionFactory.getHorse();

        System.out.println("На закате стоял рыцарь и его лошадь");
        rider.typeOfRider();
        action.someAction();
        horse.typeOfHorse();
    }
}
