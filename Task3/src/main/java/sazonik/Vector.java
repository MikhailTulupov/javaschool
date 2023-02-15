package sazonik;

import java.util.Random;

public class Vector {
    private int x,y,z;
    Vector(int x, int y ,int z){
        this.x = x;
        this.y = y;
        this.z = x;
    }


    public double getLength() {
        return  Math.sqrt(Math.pow(this.x, 2) +
                Math.pow(this.y, 2) +
                Math.pow(this.z, 2));
    }


    public static int scalarProduct(Vector frst, Vector scnd) {
        return  frst.x * scnd.x +
                frst.y * scnd.y +
                frst.z * scnd.z;
    }


    public static Vector vectorProduct(Vector frst, Vector scnd) {
        return new Vector(
                frst.y * scnd.z -  frst.z * scnd.y,
                frst.z * scnd.x - frst.x * scnd.z,
                frst.x * scnd.y - frst.y * scnd.x);
    }


    public static double angleBetween(Vector frst, Vector scnd) {
        return Vector.scalarProduct(frst, scnd) / (frst.getLength() * scnd.getLength());
    }


    public static Vector sum(Vector frst, Vector scnd) {
        return new Vector(
                frst.x + scnd.x,
                frst.y + scnd.y,
                frst.z + scnd.z);
    }


    public static Vector dif(Vector frst, Vector scnd) {
        return new Vector(
                frst.x - scnd.x,
                frst.y - scnd.y,
                frst.z - scnd.z);
    }


    public static Vector[] random(int n) {
        Vector[] vecarr = new Vector[n];
        for (int i = 0; i < n; i++) {
            Random rnd = new Random();
            vecarr[i] = new Vector(rnd.nextInt(), rnd.nextInt(), rnd.nextInt());
        }
        return vecarr;


    }

}

