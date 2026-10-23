package model;

/** Berkas digital tidak memiliki rak, sehingga TIDAK mengimplementasikan Terarsip. */
public class BerkasDigital extends Koleksi {

    private final int ukuranMB;
    private final String tautanUnduh;

    public BerkasDigital(String kode, String judul, int tahunTerbit, int ukuranMB, String tautanUnduh) {
        super(kode, judul, tahunTerbit);
        this.ukuranMB = ukuranMB;
        this.tautanUnduh = tautanUnduh;
    }

    @Override
    public String jenis() {
        return "BerkasDigital";
    }

    @Override
    public boolean layakDipinjam() {
        return true;
    }

    @Override
    public String alasanTidakLayak() {
        return "";
    }

    @Override
    public String deskripsi() {
        return super.deskripsi() + " | " + ukuranMB + " MB | " + tautanUnduh;
    }

    public int getUkuranMB() {
        return ukuranMB;
    }

    public String getTautanUnduh() {
        return tautanUnduh;
    }
}
