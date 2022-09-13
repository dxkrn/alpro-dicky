package percabangan;

import java.util.Scanner;

public class Percabangan {
    public static void main(String[] args) {
        Scanner inputUser = new Scanner(System.in);

        String nama;
        int nilai;
        String keterangan;

        System.out.print("Masukkan nama : ");
        nama = inputUser.nextLine();
        System.out.print("Masukkan nilai : ");
        nilai = inputUser.nextInt();

        if (nilai >= 60) {
            keterangan = "Lulus";
        } else {
            keterangan = "Tidak Lulus";
        }

        System.out.println();
        System.out.println(nama + " " + keterangan);
    }
}
