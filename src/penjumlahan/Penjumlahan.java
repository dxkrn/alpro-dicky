package penjumlahan;

import java.util.Scanner;

public class Penjumlahan {
    public static void main(String[] args) {
        Scanner inputUser = new Scanner(System.in);

        int x, y, hasil;

        System.out.println("Masukkan nilai :");
        System.out.print("x : ");
        x = inputUser.nextInt();
        System.out.print("y : ");
        y = inputUser.nextInt();

        hasil = x + y;

        System.out.println("Hasil " + x + " + " + y + "= " + hasil);

    }
}
