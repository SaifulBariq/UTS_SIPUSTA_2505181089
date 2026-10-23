package layanan;

import java.util.Comparator;
import model.Koleksi;

/** Urutan: koleksi layak pinjam lebih dulu, lalu berdasarkan judul (A-Z). */
public class UrutLayakLaluJudul implements Comparator<Koleksi> {

    // Comparator berlapis: kriteria pertama layak/tidak, kriteria kedua judul.
    private final Comparator<Koleksi> aturan = Comparator
            .comparing((Koleksi k) -> !k.layakDipinjam())   // false (layak) diurutkan lebih dulu
            .thenComparing(Koleksi::getJudul, String.CASE_INSENSITIVE_ORDER);

    @Override
    public int compare(Koleksi a, Koleksi b) {
        return aturan.compare(a, b);
    }
}
