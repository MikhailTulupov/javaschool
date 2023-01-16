package tuzov;


import java.util.Random;


public class Vec3d {
    final private int x, y, z;


    Vec3d(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }


    public double get_length() {
        return Math.sqrt(Math.pow(this.x, 2) +
                Math.pow(this.y, 2) +
                Math.pow(this.z, 2));
    }


    public static int scalar_product(Vec3d vec1, Vec3d vec2) {
        return vec1.x * vec2.x +
                vec1.y * vec2.y +
                vec1.z * vec2.z;
    }


    public static Vec3d vector_product(Vec3d vec1, Vec3d vec2) {
        return new Vec3d(vec1.y * vec2.z -  vec1.z * vec2.y,
                vec1.z * vec2.x - vec1.x * vec2.z,
                vec1.x * vec2.y - vec1.y * vec2.x);
    }


    public static double angle_between(Vec3d vec1, Vec3d vec2) {
        return Vec3d.scalar_product(vec1, vec2) / (vec1.get_length() * vec2.get_length());
    }


    public static Vec3d sum(Vec3d vec1, Vec3d vec2) {
        return new Vec3d(vec1.x + vec2.x,
                vec1.y + vec2.y,
                vec1.z + vec2.z);
    }


    public static Vec3d dif(Vec3d vec1, Vec3d vec2) {
        return new Vec3d(vec1.x - vec2.x,
                vec1.y - vec2.y,
                vec1.z - vec2.z);
    }


    public static Vec3d[] random(int n) {
        Vec3d[] vecarr = new Vec3d[n];
        for (int i = 0; i < n; i++) {
            Random rnd = new Random();
            vecarr[i] = new Vec3d(rnd.nextInt(), rnd.nextInt(), rnd.nextInt());
        }
        return vecarr;
    }
}
