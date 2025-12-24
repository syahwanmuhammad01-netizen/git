// File: Penumpang.java
import java.util.Scanner;

abstract class Penumpang {
    protected String nama;
    protected String noTiket;

    public Penumpang(String nama, String noTiket) {
        this.nama = nama;
        this.noTiket = noTiket;
    }

    // Abstraksi: Method ini harus diimplementasikan oleh subclass
    public abstract double hitungHargaTiket();

    // Overloading: Versi pertama tanpa parameter
    public void tampilkanData() {
        System.out.println("Nama       : " + nama);
        System.out.println("No Tiket   : " + noTiket);
        System.out.println("Harga Tiket: Rp " + hitungHargaTiket());
    }

    // Overloading: Versi kedua dengan parameter String pesan
    public void tampilkanData(String pesan) {
        tampilkanData(); // Panggil versi tanpa parameter
        System.out.println(pesan);
    }
}

class PenumpangReguler extends Penumpang {
    private static final double HARGA_DASAR = 100000.0; // Harga tiket reguler

    public PenumpangReguler(String nama, String noTiket) {
        super(nama, noTiket);
    }

    // Overriding: Implementasi spesifik untuk PenumpangReguler
    @Override
    public double hitungHargaTiket() {
        return HARGA_DASAR;
    }
}

class PenumpangVIP extends Penumpang {
    private static final double HARGA_DASAR = 250000.0; // Harga tiket VIP

    public PenumpangVIP(String nama, String noTiket) {
        super(nama, noTiket);
    }

    // Overriding: Implementasi spesifik untuk PenumpangVIP
    @Override
    public double hitungHargaTiket() {
        return HARGA_DASAR;
    }
}

// File: Main.java
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Mengambil input pengguna
        System.out.print("Masukkan nama penumpang: ");
        String nama = scanner.nextLine();

        System.out.print("Masukkan nomor tiket: ");
        String noTiket = scanner.nextLine();

        // Membuat objek Penumpang Reguler
        Penumpang penumpangReguler = new PenumpangReguler(nama, noTiket);

        // Membuat objek Penumpang VIP
        Penumpang penumpangVIP = new PenumpangVIP(nama + " (VIP)", noTiket + "-VIP");

        // Menampilkan data penumpang
        System.out.println("\n=== Data Penumpang Reguler ===");
        penumpangReguler.tampilkanData(); // Memanggil overload pertama

        System.out.println("\n=== Data Penumpang VIP ===");
        penumpangVIP.tampilkanData("Terima kasih telah memilih layanan VIP!"); // Memanggil overload kedua

        // Demonstrasi Polimorfisme
        System.out.println("\n=== Demonstrasi Polimorfisme ===");
        Penumpang[] daftarPenumpang = {penumpangReguler, penumpangVIP};
        for (Penumpang p : daftarPenumpang) {
            p.tampilkanData();
            System.out.println("---");
        }

        scanner.close();
    }
}