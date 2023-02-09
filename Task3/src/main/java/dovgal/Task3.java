package dovgal;

import java.util.Random;

public class Task3 {
    private int x, y, z;

    Task3(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double length() {
        return Math.sqrt(Math.pow(this.x, 2) +
                Math.pow(this.y, 2) + Math.pow(this.z, 2));
    }

    public static int multiplication(Task3 number1, Task3 number2) {
        return number1.x * number2.x +
                number1.y * number2.y +
                number1.z * number2.z;
    }

    public static Task3 vectorMultiplication(Task3 number1, Task3 number2) {
        return new Task3(number1.y * number2.z - number1.z * number2.y,
                number1.z * number2.x - number1.x * number2.z,
                number1.x * number2.y - number1.y * number2.x);
    }

    public static double angle(Task3 number1, Task3 number2) {
        return Task3.multiplication(number1, number2) / (number1.length() * number2.length());
    }

    public static Task3 sum(Task3 number1, Task3 number2) {
        return new Task3(number1.x + number2.x,
                number1.y + number2.y,
                number1.z + number2.z);
    }

    public static Task3 nesum(Task3 number1, Task3 number2) {
        return new Task3(number1.x - number2.x,
                number1.y - number2.y,
                number1.z - number2.z);
    }

    public static Task3[] last(int n) {
        Task3[] nubersArray = new Task3[n];
        Random rnd = new Random();
        for (int i = 0; i < n; i++) {
            nubersArray[i] = new Task3(rnd.nextInt(), rnd.nextInt(), rnd.nextInt());
        }
        return nubersArray;
    }
}