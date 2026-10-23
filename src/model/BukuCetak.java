package model;

public class BukuCetak extends Koleksi implements Terarsip {

    private final int jumlahHalaman;
    private final String nomorRak;
    private final String lokasiLantai;
    private final boolean sedangDiperbaiki;

    public BukuCetak(String kode, String judul, int tahunTerbit, int jumlahHalaman,
                     String nomorRak, String lokasiLantai, boolean sedangDiperbaiki) {
        super(kode, judul, tahunTerbit);
        this.jumlahHalaman = jumlahHalaman;
        this.nomorRak = nomorRak;
        this.lokasiLantai = lokasiLantai;
        this.sedangDiperbaiki = sedangDiperbaiki;
    }

    @Override
    public String jenis() {
        return "BukuCetak";
    }

    @Override
    public boolean layakDipinjam() {
        return !sedangDiperbaiki;
    }

    @Override
    public String alasanTidakLayak() {
        return layakDipinjam() ? "" : "buku ini sedang diperbaiki";
    }

    @Override
    public String deskripsi() {
        return super.deskripsi() + " | " + jumlahHalaman + " halaman | " + ringkasanArsip();
    }

    @Override
    public String nomorRak() {
        return nomorRak;
    }

    @Override
    public String lokasiLantai() {
        return lokasiLantai;
    }

    public int getJumlahHalaman() {
        return jumlahHalaman;
    }

    public boolean isSedangDiperbaiki() {
        return sedangDiperbaiki;
    }
}
