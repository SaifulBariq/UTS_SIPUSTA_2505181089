import eksepsi.PustakaException;
import java.io.IOException;
import layanan.EksporKatalog;
import layanan.KatalogPerpustakaan;
import layanan.UrutLayakLaluJudul;
import model.BerkasDigital;
import model.BukuCetak;
import model.Majalah;

public class Main {

    public static void main(String[] args) {
        BukuCetak bk1 = new BukuCetak("BK-001", "Java How to Program", 2022, 620, "A-12", "Lantai 1", false);
        BukuCetak bk2 = new BukuCetak("BK-002", "Basis Data Relasional", 2021, 410, "B-04", "Lantai 2", true);
        Majalah mj1 = new Majalah("MJ-001", "Info Teknologi Edisi 88", 2026, 88, "Agustus", true, "M-01", "Lantai 1");
        Majalah mj2 = new Majalah("MJ-002", "Info Teknologi Edisi 87", 2026, 87, "Juli", false, "M-01", "Lantai 1");
        BerkasDigital bd1 = new BerkasDigital("BD-001", "Panduan Pemrograman Java", 2024, 15, "unduh.polmed.ac.id/bd001");
        BerkasDigital bd2 = new BerkasDigital("BD-002", "Jurnal Rekayasa Perangkat", 2025, 8, "unduh.polmed.ac.id/bd002");

        KatalogPerpustakaan katalog = new KatalogPerpustakaan();
        katalog.tambah(bk1);
        katalog.tambah(bk2);
        katalog.tambah(mj1);
        katalog.tambah(mj2);
        katalog.tambah(bd1);
        katalog.tambah(bd2);

        System.out.println("=== [1] Deskripsi (override + super) ===");
        System.out.println(bk1.deskripsi());
        System.out.println(mj1.deskripsi());
        System.out.println(bd1.deskripsi());

        System.out.println("\n=== [2] Ringkasan arsip (interface Terarsip) ===");
        System.out.println(bk1.getKode() + ": " + bk1.ringkasanArsip());
        System.out.println(mj1.getKode() + ": " + mj1.ringkasanArsip());
        System.out.println(bd1.getKode() + ": (tidak memiliki rak)");

        System.out.println("\n=== [3] Cetak status (polimorfik) ===");
        katalog.cetakStatus();

        System.out.println("\n=== [4] Urut: layak dulu, lalu judul ===");
        katalog.urut(new UrutLayakLaluJudul());
        katalog.cetakStatus();

        System.out.println("\n=== [5] Peminjaman & eksepsi ===");
        coba(katalog, "BK-001");   // berhasil
        coba(katalog, "BK-001");   // sedang dipinjam
        coba(katalog, "BK-002");   // tidak layak (diperbaiki)
        coba(katalog, "MJ-001");   // tidak layak (edisi terbaru)
        coba(katalog, "BD-001");   // berhasil
        coba(katalog, "XX-999");   // tidak ditemukan

        System.out.println("\n=== [6] Ekspor ke katalog.txt ===");
        try {
            new EksporKatalog().ekspor(katalog, "katalog.txt");
            System.out.println("Berhasil menulis katalog.txt");
        } catch (IOException e) {
            System.out.println("Gagal menulis berkas: " + e.getMessage());
        }
    }

    private static void coba(KatalogPerpustakaan katalog, String kode) {
        try {
            katalog.pinjam(kode);
            System.out.println("[OK]    " + kode + " berhasil dipinjam.");
        } catch (PustakaException e) {
            System.out.println("[GAGAL] " + e.getMessage());
        }
    }
}
