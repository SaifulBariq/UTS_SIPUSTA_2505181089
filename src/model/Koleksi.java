package model;

/** Kelas induk seluruh jenis koleksi perpustakaan. */
public abstract class Koleksi {

    private final String kode;
    private final String judul;
    private final int tahunTerbit;
    private boolean sedangDipinjam;

    protected Koleksi(String kode, String judul, int tahunTerbit) {
        this.kode = kode;
        this.judul = judul;
        this.tahunTerbit = tahunTerbit;
    }

    /** Nama jenis koleksi, mis. "BukuCetak". */
    public abstract String jenis();

    /** Aturan kelayakan pinjam; berbeda untuk tiap jenis koleksi. */
    public abstract boolean layakDipinjam();

    /** Alasan koleksi tidak layak dipinjam, dalam bahasa yang mudah dipahami. */
    public abstract String alasanTidakLayak();

    /** Deskripsi dasar; diperluas oleh setiap turunan memakai super. */
    public String deskripsi() {
        return jenis() + " " + kode + " \"" + judul + "\" (" + tahunTerbit + ")";
    }

    public String getKode() {
        return kode;
    }

    public String getJudul() {
        return judul;
    }

    public int getTahunTerbit() {
        return tahunTerbit;
    }

    public boolean isSedangDipinjam() {
        return sedangDipinjam;
    }

    public void setSedangDipinjam(boolean sedangDipinjam) {
        this.sedangDipinjam = sedangDipinjam;
    }
}
