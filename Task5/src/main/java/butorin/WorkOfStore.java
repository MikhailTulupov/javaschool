package butorin;

import butorin.Store.StoreComunityFactory;

public class WorkOfStore {
    public static void main(String[] args) {
        ComunityFactory comunityFactory = new StoreComunityFactory();
        Admin admin =  comunityFactory.getAdmin();
        Customer customer = comunityFactory.getCustomer();
        Worker worker = comunityFactory.getWorker();

        System.out.println("The store started working..");
        worker.doSomeWork();
        customer.buySomeProduct();
        admin.manage();

    }
}
