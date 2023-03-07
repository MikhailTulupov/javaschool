package butorin.Store;

import butorin.Worker;

public class Seller implements Worker {
    @Override
    public void doSomeWork() {
        System.out.println("Seller sell some product to buyer..");
    }
}
