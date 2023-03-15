package kachevskaya.Castle;

import kachevskaya.Seller;

public class OldSeller implements Seller {

    @Override
    public void sellerDoSomething() {
        System.out.println("Старый продавец сказал сколько стоит меч...");
    }
}
