package kachevskaya;

import kachevskaya.Castle.CastleFactory;
import kachevskaya.Castle.OldSeller;

public class CastleSellerFactory {
    public static void main(String[] args) {
        DoingFactory doingFactory = new CastleFactory();
        Seller seller = doingFactory.getSeller();
        Money money = doingFactory.getMoney();
        TypeOfSword typeOfSword = doingFactory.getTypeOfSword();

        System.out.println("Встреча путника и старого торговца...");
        seller.sellerDoSomething();
        money.giveMoney();
        typeOfSword.shining();
    }
}
