package model;

/**
 * Kontrak untuk koleksi yang memiliki lokasi fisik di rak.
 * Hanya diterapkan pada BukuCetak dan Majalah (BerkasDigital tidak punya rak).
 */
public interface Terarsip {

    String nomorRak();

    String lokasiLantai();

    default String ringkasanArsip() {
        return "Rak " + nomorRak() + ", " + lokasiLantai();
    }
}
