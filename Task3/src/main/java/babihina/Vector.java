package babihina;

import java.util.Random;

public class Vector {
    final private int x, y, z;

    Vector(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public static int scalarnoeProizvidenee(Vector vector1, Vector vector2) {
        return vector1.x * vector2.x + vector1.y * vector2.y + vector1.z * vector2.z;
    }

    public static Vector vectornoeProizvidenee (Vector vec1, Vector vec2) {
        return new Vector(vec1.y * vec2.z - vec1.z * vec2.y,
                vec1.z * vec2.x - vec1.x * vec2.z,
                vec1.x * vec2.y - vec1.y * vec2.x);
    }

    public static double uguluMezhdu(Vector vec1, Vector vec2) {
        return Vector.scalarnoeProizvidenee(vec1, vec2) / (vec1.length() * vec2.length());
    }

    public  static Vector summa(Vector vec1, Vector vec2) {
        return new Vector(vec1.x + vec2.x,
                vec1.y + vec2.y,
                vec1.z + vec2.z);
    }

    public static Vector raznica (Vector vec1, Vector vec2) {
        return new Vector(vec1.x - vec2.x,
                vec1.y - vec2.y,
                vec1.z - vec2.z);
    }

    public static Vector[] random(int n) {
        Vector[] vecarr = new Vector[n];
        for (int i = 0; i < n; i++) {
            Random rnd = new Random();
            vecarr[i] = new Vector(rnd.nextInt(), rnd.nextInt(), rnd.nextInt());
        }
        return vecarr;
}
