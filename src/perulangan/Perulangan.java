//PERTEMUAN MINGGU KE-4

package perulangan;
import java.util.Scanner;

public class Perulangan {
    public static void main(String[] args) {
        //deklarasi dan inisialisasi
        Scanner inputUser = new Scanner(System.in);
        int i = 1;
        int n;

        //input nilai n
        System.out.print("Nilai n = ");
        n = inputUser.nextInt();

        //perulangan
        while(i <= 2 * n) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
            i++;
        }

    }
}
