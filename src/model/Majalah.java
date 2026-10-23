package model;

public class Majalah extends Koleksi implements Terarsip {

    private final int edisi;
    private final String bulanTerbit;
    private final boolean edisiTerbaru;
    private final String nomorRak;
    private final String lokasiLantai;

    public Majalah(String kode, String judul, int tahunTerbit, int edisi, String bulanTerbit,
                   boolean edisiTerbaru, String nomorRak, String lokasiLantai) {
        super(kode, judul, tahunTerbit);
        this.edisi = edisi;
        this.bulanTerbit = bulanTerbit;
        this.edisiTerbaru = edisiTerbaru;
        this.nomorRak = nomorRak;
        this.lokasiLantai = lokasiLantai;
    }

    @Override
    public String jenis() {
        return "Majalah";
    }

    @Override
    public boolean layakDipinjam() {
        return !edisiTerbaru;
    }

    @Override
    public String alasanTidakLayak() {
        return layakDipinjam() ? "" : "majalah ini adalah edisi terbaru";
    }

    @Override
    public String deskripsi() {
        return super.deskripsi() + " | edisi " + edisi + ", " + bulanTerbit + " | " + ringkasanArsip();
    }

    @Override
    public String nomorRak() {
        return nomorRak;
    }

    @Override
    public String lokasiLantai() {
        return lokasiLantai;
    }

    public int getEdisi() {
        return edisi;
    }

    public String getBulanTerbit() {
        return bulanTerbit;
    }

    public boolean isEdisiTerbaru() {
        return edisiTerbaru;
    }
}
