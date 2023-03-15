package kachevskaya.Castle;

import kachevskaya.Money;

public class Gold implements Money {
    @Override
    public void giveMoney() {
        System.out.println("Путник дал золотых монет старцу...");
    }
}
