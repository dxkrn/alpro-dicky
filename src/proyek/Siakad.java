package proyek;
import java.util.ArrayList;
import java.util.Scanner;

public class Siakad {

    static ArrayList<Mahasiswa> dataMahasiswa = new ArrayList<>();
    static Scanner inputUser = new Scanner(System.in);

    public static void main(String[] args) {

        int inputPilihan;
        do {
                System.out.println("===================");
                System.out.println("|   MENU SIAKAD   |");
                System.out.println("===================");
                System.out.println("| 1 | Tambah Data |");
                System.out.println("| 2 | Lihat Data  |");
                System.out.println("| 3 | Keluar      |");
                System.out.println("===================");
                System.out.print("Pilihan Menu : ");
                inputPilihan = inputUser.nextInt();
                System.out.println();
            switch (inputPilihan) {
                case 1 -> tambahData();
                case 2 -> lihatData();
                case 3 -> {
                            System.out.println("Terima kasih");
                            System.exit(0);
                        }
                default -> System.out.println("Pilihan tidak sesuai");
            }
        } while (true);
    }

    public static void tambahData() {
        String nim;
        String nama;
        System.out.println("------------------------");
        System.out.println("| Silahkan tambah data |");
        System.out.println("------------------------");
        System.out.print("Nim : ");
        nim = inputUser.next();
        inputUser.nextLine();
        System.out.print("Nama : ");
        nama = inputUser.nextLine();
        dataMahasiswa.add(new Mahasiswa(nim, nama));

        System.out.println();
    }

    public static void lihatData() {
        System.out.println("------------------------");
        System.out.println("|    Data Mahasiswa    |");
        System.out.println("------------------------");

        for(int i = 0; i < dataMahasiswa.size(); i++) {
            System.out.println("No. " + (i+1));
            System.out.print("\tNim : " + dataMahasiswa.get(i).getNim());
            System.out.println();
            System.out.print("\tNama : " + dataMahasiswa.get(i).getNama());
            System.out.println();
        }
    }
}
