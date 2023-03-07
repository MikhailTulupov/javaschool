package butorin.Store;

import butorin.Customer;

public class Buyer implements Customer {
    @Override
    public void buySomeProduct() {
        System.out.println("Buyer buying some milk for 3$..");
    }
}
