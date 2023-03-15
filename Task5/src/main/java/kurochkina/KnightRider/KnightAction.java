package kurochkina.KnightRider;

import kurochkina.Action;
import kurochkina.ActionFactory;
import kurochkina.Horse;
import kurochkina.Rider;

public class KnightAction implements ActionFactory {
    @Override
    public Action getAction() {
        return new SatDown();
    }

    @Override
    public Rider getRider() {
        return new Knight();
    }

    @Override
    public Horse getHorse() {
        return new BlackHorse();
    }
}
