package perulangan.latihan;
import java.util.Scanner;

public class Perulangan2 {
    public static void main(String[] args) {
        Scanner inputUser = new Scanner(System.in);
        int n;

        System.out.print("Nilai n = ");
        n = inputUser.nextInt();

        for (int i = 1; i <= n * 2; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
    }
}
