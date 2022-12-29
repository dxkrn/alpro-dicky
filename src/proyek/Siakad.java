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
            System.out.println("| 4 | Cari Data    |");
            System.out.println("| 5 | Edit Data    |");
            System.out.println("| 6 | Hapus Data   |");
            System.out.println("| 7 | Keluar       |");
            System.out.println("====================");
            System.out.print("Pilihan Menu : ");
            inputPilihan = inputUser.nextInt();
            System.out.println();
            switch (inputPilihan) {
                case 1 -> tambahData();
                case 2 -> lihatData();
                case 3 -> urutkanData();
                case 4 -> cariData();
//                case 5 -> editData();
                case 6 -> hapusData();
                case 7 -> {
                    System.out.println("Terima kasih");
                    System.exit(0);
                }
                default -> System.out.println("Pilihan tidak sesuai");
            }
        } while (true);
    }

    //Tambah Data
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

    //Lihat Data
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

    //Edit Data


    //Hapus Data
    public static void hapusData() {
        do {
            System.out.println("---------------------");
            System.out.println("|     Hapus Data    |");
            System.out.println("---------------------");
            System.out.println("| 1 | Data tertentu |");
            System.out.println("| 2 | Semua data    |");
            System.out.println("| 3 | Batal         |");
            System.out.println("---------------------");
            System.out.print("Pilihan Anda : ");
            inputPilihan = inputUser.nextInt();
            System.out.println();
            switch (inputPilihan) {
                case 1 -> hapusSingleData();
                case 2 -> hapusAllData();
                case 3 -> main(null);
                default -> System.out.println("Pilihan tidak sesuai");
            }
        } while (inputPilihan < 1 || inputPilihan > 3);
    }

    public static void hapusSingleData(){
        System.out.println("---------------------");
        System.out.println("|     Hapus Data    |");
        System.out.println("---------------------");
        System.out.print("Masukkan NIM : ");
        String inputNIM = inputUser.next();
        inputUser.nextLine();
        int indexData = binarySearch(dataMahasiswa, inputNIM);
        if (indexData != -1) {
            System.out.println("Yakin hapus data dengan nim \"" + dataMahasiswa.get(indexData).getNim() + "\"?[Y/T]");
            String inputKonfirmasi = inputUser.next();
            if (inputKonfirmasi.charAt(0) == 'Y' || inputKonfirmasi.charAt(0) == 'y') {
                dataMahasiswa.remove(indexData);
                System.out.println("Alert: Data berhasil dihapus!");
            } else {
                System.out.println("Alert: Data gagal dihapus!");
                main(null);
            }
        } else {
            System.out.println("Alert: Data tidak ditemukan!");
        }
    }

    public static void hapusAllData(){
        System.out.println("Yakin hapus semua data?[Y/T]");
        String inputKonfirmasi = inputUser.next();
        if (inputKonfirmasi.charAt(0) == 'Y' || inputKonfirmasi.charAt(0) == 'y') {
            System.out.println("Menghapus semua data...");
            dataMahasiswa.clear();
            System.out.println("Semua data berhasil dihapus!");
        } else {
            System.out.println("Alert: Semua data gagal dihapus!");
            main(null);
        }
    }

    //SORTING
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
                case 3 -> quickSort();
//                case 4 -> insertionSort();
//                case 5 -> bubbleSort();
//                case 6 -> shellSort();
//                case 7 -> binaryInsertionSort();
                case 8 -> main(null);
                default -> System.out.println("Pilihan tidak sesuai");
            }
        } while (inputPilihan < 1 || inputPilihan > 8);
    }


    //SORTING ALGORITHM

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


    //Quick Sort
    public static int partition(ArrayList<Mahasiswa> dataList, int begin, int end) {
        int pivot = Integer.parseInt(dataList.get(end).getNim());
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (Integer.parseInt(dataMahasiswa.get(j).getNim()) <= pivot) {
                i++;

                Mahasiswa temp = dataList.get(i);
                dataList.set(i, dataList.get(j));
                dataList.set(j, temp);
            }
        }

        Mahasiswa temp = dataList.get(i+1);
        dataList.set((i+1), dataList.get(end));
        dataList.set(end, temp);

        return i+1;
    }

    public static void quickSorting(ArrayList<Mahasiswa> dataList, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(dataList, begin, end);

            quickSorting(dataList, begin, partitionIndex-1);
            quickSorting(dataList, partitionIndex+1, end);

        }
    }

    public static void quickSort(){
        System.out.println("Running Quick Sort...");
        quickSorting(dataMahasiswa, 0, dataMahasiswa.size()-1);
        System.out.println("Quick Sort Successfully!");
    }




    //SEARCH

    public static void cariData(){
        do {
            System.out.println("---------------------");
            System.out.println("|     Cari Data     |");
            System.out.println("---------------------");
            System.out.println("| 1 | Linear Search |");
            System.out.println("| 2 | Binary Search |");
            System.out.println("| 3 | Batal         |");
            System.out.println("---------------------");
            System.out.print("Pilihan Anda : ");
            inputPilihan = inputUser.nextInt();
            System.out.println();
            switch (inputPilihan) {
                case 1 -> cariDataLinear();
                case 2 -> cariDataBinary();
                case 3 -> main(null);
                default -> System.out.println("Pilihan tidak sesuai");
            }
        } while (inputPilihan < 1 || inputPilihan > 3);
    }


    //Linear Search
    public static void cariDataLinear(){
        System.out.println("---------------------");
        System.out.println("|   Linear Search   |");
        System.out.println("---------------------");
        System.out.print("Masukkan NIM : ");
        String inputNIM = inputUser.next();
        inputUser.nextLine();
        System.out.println("Mencari data dengan nim \"" + inputNIM + "\"...");
        int indexData = linearSearch(dataMahasiswa, inputNIM);
        if (indexData != -1) {
            System.out.println("Alert : Data ditemukan!");
            System.out.println("===========================================");
            System.out.println("|             Data Mahasiswa              |");
            System.out.println("===========================================");
            System.out.println("| NO |     NIM     |         NAMA         |");
            System.out.println("===========================================");
            System.out.printf("| %2d | %-11s | %-20s |\n", (indexData+1), dataMahasiswa.get(indexData).getNim(), dataMahasiswa.get(indexData).getNama());
            System.out.println("-------------------------------------------");
        } else {
            System.out.println("Alert : Data tidak ditemukan!");
        }
    }
    public static int linearSearch(ArrayList<Mahasiswa> listMahasiswa, String nim) {
        for (int i = 0; i < listMahasiswa.size(); i++) {
            if (nim.equals(listMahasiswa.get(i).getNim())) {
                return i;
            }
        }
        return -1;
    }


    //Binary Search
    public static void cariDataBinary() {
        System.out.println("---------------------");
        System.out.println("|   Binary Search   |");
        System.out.println("---------------------");
        System.out.print("Masukkan NIM : ");
        String inputNIM = inputUser.next();
        inputUser.nextLine();
        System.out.println("Mencari data dengan nim \"" + inputNIM + "\"...");
        int indexData = binarySearch(dataMahasiswa, inputNIM);
        if (indexData != -1) {
            System.out.println("Alert : Data ditemukan!");
            System.out.println("===========================================");
            System.out.println("|             Data Mahasiswa              |");
            System.out.println("===========================================");
            System.out.println("| NO |     NIM     |         NAMA         |");
            System.out.println("===========================================");
            System.out.printf("| %2d | %-11s | %-20s |\n", (indexData+1), dataMahasiswa.get(indexData).getNim(), dataMahasiswa.get(indexData).getNama());
            System.out.println("-------------------------------------------");
        } else {
            System.out.println("Alert : Data tidak ditemukan!");
        }
    }

    public static int binarySearch(ArrayList<Mahasiswa> listMahasiswa, String nim) {
        quickSorting(dataMahasiswa, 0, dataMahasiswa.size()-1);
        int l = 0, r = listMahasiswa.size()-1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            if (dataMahasiswa.get(m).getNim().equals(nim)) {
                return m;
            }

            if (Integer.parseInt(dataMahasiswa.get(m).getNim()) < Integer.parseInt(nim)) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }

}
