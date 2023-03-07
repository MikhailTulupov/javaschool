package butorin.Store;

import butorin.Admin;

public class Administrator implements Admin {

    @Override
    public void manage() {
        System.out.println("The administrator monitors the buyer and how the employee performs the work..");
    }
}
