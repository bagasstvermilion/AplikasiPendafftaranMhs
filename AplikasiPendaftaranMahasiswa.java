import java.util.Scanner;
public class AplikasiPendaftaranMahasiswa {
    static String[] nama = new String[100];
    static String[] jurusan = new String[100];
    static int[][] nilaiMahasiswa = new int[100][2];
    static int jumlahMahasiswa = 0;

    public static void inputDataMahasiswa() {
        Scanner in = new Scanner(System.in);
        System.out.println("===== Input Data Calon Mahasiswa =====");
        System.out.print("\nMasukkan Nama: ");
        nama[jumlahMahasiswa] = in.next();
        System.out.print("Masukkan Jurusan: ");
        jurusan[jumlahMahasiswa] = in.next();
        System.out.print("Masukkan Nilai Test Ke-1: ");
        nilaiMahasiswa[jumlahMahasiswa][0] = in.nextInt();
        System.out.print("Masukkan Nilai Test Ke-2: ");
        nilaiMahasiswa[jumlahMahasiswa][1] = in.nextInt();
        jumlahMahasiswa++;
        System.out.println("\nData Berhasil Di-Tambahkan!");
    }

    public static int cariIndeksDataMahasiswaBerdasarkanNama(String cariNama) {
        for (int i = 0; i < 100; i++) {
            if (nama[i].equals(cariNama)) {
                return i;
            }
        }
        return -1;
    }

    public static void editNilaiCalonMahasiswa(String cariNama) {
        Scanner in = new Scanner(System.in);
        int indeks = cariIndeksDataMahasiswaBerdasarkanNama(cariNama);
        if (indeks == -1) {
            System.out.println("Maaf mahasiswa dengan nama tersebut tidak dapat ditemukan");
        } else {
            System.out.print("Masukkan Nilai Test Ke-1: ");
            int nilai1 = in.nextInt();
            nilaiMahasiswa[indeks][0] = nilai1;

            System.out.print("Masukkan Nilai Test Ke-2: ");
            int nilai2 = in.nextInt();
            nilaiMahasiswa[indeks][1] = nilai2;
            System.out.println("Nilai Mahasiswa Berhasil Di-Ubah!");
        }
        
    }

    public static int cariNilaiTertinggi() {
        int indeks = -1;
        int tertinggi = 0;
        for (int i = 0; i < 100; i++) {
            if ((nilaiMahasiswa[i][0] + nilaiMahasiswa[i][1]) > tertinggi) {
                tertinggi = nilaiMahasiswa[i][0] + nilaiMahasiswa[i][1];
                indeks = i;
            }
        }
        return indeks;
    }

    public static void tampilkanNilaiTertinggi() {
        int indeks = cariNilaiTertinggi();
        if (indeks == -1) {
            System.out.println("Tidak Ada Data Mahasiswa");
        } else {
            System.out.println("\n===== Mahasiswa Dengan Nilai Tertinggi =====");
            System.out.println("\nNama : " + nama[indeks]);
            System.out.println("Jurusan : " + jurusan[indeks]);
            System.out.println("Nilai Test Ke-1 : " + nilaiMahasiswa[indeks][0]);
            System.out.println("Nilai Test Ke-2 : " + nilaiMahasiswa[indeks][1]);
        }
    }

    public static void menu() {
        System.out.println("\n===== Aplikasi Pendaftaran Mahasiswa =====");
        System.out.println("1. Tambah Data Calon Mahasiswa");
        System.out.println("2. Hapus Data Calon Mahasiswa");
        System.out.println("3. Edit Nilai Test");
        System.out.println("4. Tampilkan Semua Data");
        System.out.println("5. Tampilkan Mahasiswa dengan Nilai Tertinggi");
        System.out.println("6. Keluar");
        System.out.print("\nPilihan : ");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String namaMhs;
        boolean isAccess = true;
        while (isAccess) {
            menu();
            int pilihan = in.nextInt();
            switch (pilihan) {
                case 1:
                    inputDataMahasiswa();
                case 2:
                    break;
                case 3:
                    System.out.print("Masukkan Nama Calon Mahasiswa: ");
                    namaMhs = in.next();
                    editNilaiCalonMahasiswa(namaMhs);
                    break;
                case 4:
                    System.out.println("Nama: " + nama[0]);
                    System.out.println("Jurusan: " + jurusan[0]);
                    System.out.println("Nilai Test Ke-1: " + nilaiMahasiswa[0][0]);
                    System.out.println("Nilai Test Ke-1: " + nilaiMahasiswa[0][1]);
                    break;
                case 5:
                    tampilkanNilaiTertinggi();
                    break;
                case 6:
                    System.out.println("\nTerimakasih Sampai Jumpa");
                    isAccess = false;
                    break;
                default:
                    System.out.println("Pilihan Tidak Valid");
                    break;
            }
        }
    }
}