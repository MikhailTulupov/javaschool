package kachevskaya.Castle;

import kachevskaya.DoingFactory;
import kachevskaya.Money;
import kachevskaya.Seller;
import kachevskaya.TypeOfSword;

public class CastleFactory implements DoingFactory {

    @Override
    public Money getMoney() {
        return new Gold();
    }

    @Override
    public Seller getSeller() {
        return new OldSeller();
    }

    @Override
    public TypeOfSword getTypeOfSword() {
        return new Diamond();
    }
}
