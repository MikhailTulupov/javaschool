package voronin;

import java.util.Random;

public class Vector {
    private double x, y, z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double lengthVector() {
        return (Math.sqrt(Math.pow(x, 2) +
                          Math.pow(y, 2) +
                          Math.pow(z, 2)));
    }

    public double scalarProduct(Vector two) {
        return (x * two.x + y * two.y + z * two.z);
    }

    public Vector VectorProduct(Vector two) {
        return new Vector(y * two.z - z * two.y,
                          z * two.x - x * two.z,
                          x * two.y - y * two.z);
    }

    public double cornerBetween(Vector two) {
        double res_a = lengthVector();
        double res_b = Math.sqrt(Math.pow(two.x, 2) + Math.pow(two.y, 2) + Math.pow(two.z, 2));
        return scalarProduct(two) / (res_a * res_b);
    }

    public Vector sumVector(Vector two) {
        return new Vector(x + two.x,
                          y + two.y,
                          z + two.z);
    }

    public Vector subVector(Vector two) {
        return new Vector(x - two.x,
                          y - two.y,
                          z - two.z);
    }

    public static Vector[] randomVector(int n) {
        Vector[] vec_arr = new Vector[n];
        for (int i = 0; i < n; i++) {
            Random rnd = new Random();
            vec_arr[i] = new Vector(rnd.nextInt(), rnd.nextInt(), rnd.nextInt());
        }
        return vec_arr;
    }
}
