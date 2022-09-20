package perulangan.soal;
import java.util.Scanner;

public class PerulanganSegitigaBintang {
    public static void main(String[] args) {

        Scanner inputUser = new Scanner(System.in);
        int n;

        System.out.print("Nilai n = ");
        n = inputUser.nextInt();


        for (int i = 1; i <= n; i++) {
            for (int j = n; j > i; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
