package plotnikov;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите вектор");
        int x = scan.nextInt();
        int y = scan.nextInt();
        int z = scan.nextInt();
        Vector vector = new Vector(x, y, z);
        System.out.println(vector.scalarProduct(new Vector(1,1,1)));
    }
}