import java.util.Scanner;

abstract class Penumpang {
    protected String nama;
    protected String noTiket;

    public Penumpang(String nama, String noTiket) {
        this.nama = nama;
        this.noTiket = noTiket;
    }

    public abstract double hitungHargaTiket();

    public void tampilkanData() {
        System.out.println("Nama       : " + nama);
        System.out.println("No Tiket   : " + noTiket);
        System.out.println("Harga Tiket: Rp " + hitungHargaTiket());
    }

    public void tampilkanData(String pesan) {
        tampilkanData();
        System.out.println(pesan);
    }
}

class PenumpangReguler extends Penumpang {
    private static final double HARGA_DASAR = 100000.0;

    public PenumpangReguler(String nama, String noTiket) {
        super(nama, noTiket);
    }

    @Override
    public double hitungHargaTiket() {
        return HARGA_DASAR;
    }
}

class PenumpangVIP extends Penumpang {
    private static final double HARGA_DASAR = 250000.0;

    public PenumpangVIP(String nama, String noTiket) {
        super(nama, noTiket);
    }

    @Override
    public double hitungHargaTiket() {
        return HARGA_DASAR;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan nama penumpang: ");
        String nama = scanner.nextLine();

        System.out.print("Masukkan nomor tiket: ");
        String noTiket = scanner.nextLine();

        Penumpang penumpangReguler = new PenumpangReguler(nama, noTiket);
        Penumpang penumpangVIP = new PenumpangVIP(nama + " (VIP)", noTiket + "-VIP");

        System.out.println("\n=== Data Penumpang Reguler ===");
        penumpangReguler.tampilkanData();

        System.out.println("\n=== Data Penumpang VIP ===");
        penumpangVIP.tampilkanData("Terima kasih telah memilih layanan VIP!");

        System.out.println("\n=== Demonstrasi Polimorfisme ===");
        Penumpang[] daftarPenumpang = { penumpangReguler, penumpangVIP };
        for (Penumpang p : daftarPenumpang) {
            p.tampilkanData();
            System.out.println("---");
        }

        scanner.close();
    }
}
