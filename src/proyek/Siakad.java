package proyek;
import java.util.ArrayList;
import java.util.Scanner;

public class Siakad {

    static ArrayList<Mahasiswa> dataMahasiswa = new ArrayList<>();
    static Scanner inputUser = new Scanner(System.in);

    static int inputPilihan;
    public static void main(String[] args) {


        do {
            System.out.println("\n====================");
            System.out.println("|   MENU SIAKAD    |");
            System.out.println("====================");
            System.out.println("| 1 | Tambah Data  |");
            System.out.println("| 2 | Lihat Data   |");
            System.out.println("| 3 | Urutkan Data |");
            System.out.println("| 4 | Keluar       |");
            System.out.println("====================");
            System.out.print("Pilihan Menu : ");
            inputPilihan = inputUser.nextInt();
            System.out.println();
            switch (inputPilihan) {
                case 1 -> tambahData();
                case 2 -> lihatData();
                case 3 -> urutkanData();
                case 4 -> {
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
        Mahasiswa mahasiswa = new Mahasiswa();
        System.out.println("------------------------");
        System.out.println("| Silahkan tambah data |");
        System.out.println("------------------------");
        System.out.print("Nim : ");
        nim = inputUser.next();
        mahasiswa.setNim(nim);
        inputUser.nextLine();
        System.out.print("Nama : ");
        nama = inputUser.nextLine();
        mahasiswa.setNama(nama);
        dataMahasiswa.add(mahasiswa);
        System.out.println();
    }

    public static void lihatData() {
        System.out.println("===========================================");
        System.out.println("|             Data Mahasiswa              |");
        System.out.println("===========================================");
        System.out.println("| NO |     NIM     |         NAMA         |");
        System.out.println("===========================================");

        for(int i = 0; i < dataMahasiswa.size(); i++) {
            System.out.printf("| %2d | %-11s | %-20s |\n", (i+1), dataMahasiswa.get(i).getNim(), dataMahasiswa.get(i).getNama());
            System.out.println("-------------------------------------------");
        }
    }

    public static void urutkanData() {
        do {
            System.out.println("------------------------------");
            System.out.println("| Pilih Algoritma Pengurutan |");
            System.out.println("------------------------------");
            System.out.println("| 1 | Exchange Sort          |");
            System.out.println("| 2 | Selection Sort         |");
            System.out.println("| 3 | Quick Sort             |");
            System.out.println("| 4 | Insertion Sort         |");
            System.out.println("| 5 | Bubble Sort            |");
            System.out.println("| 6 | Shell Sort             |");
            System.out.println("| 7 | Binary Insertion Sort  |");
            System.out.println("| 8 | Batal                  |");
            System.out.println("------------------------------");
            System.out.print("Pilihan Anda : ");
            inputPilihan = inputUser.nextInt();
            System.out.println();
            switch (inputPilihan) {
                case 1 -> exchangeSort();
                case 2 -> selectionSort();
//                case 3 -> quickSort();
//                case 4 -> insertionSort();
//                case 5 -> bubbleSort();
//                case 6 -> shellSort();
//                case 7 -> binaryInsertionSort();
                case 8 -> main(null);
                default -> System.out.println("Pilihan tidak sesuai");
            }
        } while (inputPilihan < 1 || inputPilihan > 8);
    }


    //SORTING

    //Exchange Sort
    public static void exchangeSort() {
        System.out.println("Running Exchange Sort...");
        for (int i = 0; i < (dataMahasiswa.size()-1); i++) {
            for (int j = i+1; j < dataMahasiswa.size(); j++) {
                if (dataMahasiswa.get(i).getNim().compareTo(dataMahasiswa.get(j).getNim()) >= 1) {
                    Mahasiswa temp = dataMahasiswa.get(i);
                    dataMahasiswa.set(i, dataMahasiswa.get(j));
                    dataMahasiswa.set(j, temp);
                }
            }
        }
        System.out.println("Exchange Sort Successfully!");
    }

    //Selection Sort
    public static void selectionSort() {
        System.out.println("Running Selection Sort...");
        for (int i = 0; i < (dataMahasiswa.size() - 1); i++) {
            int index = i;
            for (int j = i + 1; j < dataMahasiswa.size(); j++) {
                if (Integer.parseInt(dataMahasiswa.get(j).getNim()) < Integer.parseInt(dataMahasiswa.get(index).getNim())) {
                    index = j;
                }
            }

            Mahasiswa tempMahasiswa = dataMahasiswa.get(index);

            dataMahasiswa.set(index, dataMahasiswa.get(i));
            dataMahasiswa.set(i, tempMahasiswa);
        }
        System.out.println("Selection Sort Successfully!");
    }


}
