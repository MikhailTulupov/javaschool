package plotnikov;

public class Vector {
    private int x, y, z;

    Vector(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double sqrt() {
        return Math.sqrt((x * x) + (y * y) + (z * z));
    }

    public double scalarProduct(Vector vector) {
        return x * vector.x + y * vector.y + z * vector.z;
    }

    public Vector vectorProduct(Vector vector) {
        return new Vector(y * vector.z - z * vector.y, z * vector.x - x * vector.z, x * vector.y - y * vector.x);
    }

    public double vectorCorner(Vector vector) {
        return scalarProduct(vector) / (sqrt() * vector.sqrt());
    }

    public Vector addVector(Vector vector) {
        return new Vector(x + vector.x, y + vector.y, z + vector.z);
    }

    public Vector subtractionVector(Vector vector) {
        return new Vector(x - vector.x, y - vector.y, z - vector.z);
    }

    public static Vector[] gen(int n) {
        Vector[] massVector = new Vector[n];
        for (int i = 0; i < massVector.length; i++) {
            massVector[i] = new Vector((int) (Math.random() * 17), (int) (Math.random() * 17), (int) (Math.random() * 17));
        }
        return massVector;
    }
}