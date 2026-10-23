package layanan;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import model.Koleksi;

public class EksporKatalog {

    private static final String[] HEADER = {"JENIS", "KODE", "JUDUL", "TAHUN", "LAYAK", "STATUS"};

    public void ekspor(KatalogPerpustakaan katalog, String namaBerkas) throws IOException {
        List<Koleksi> daftar = katalog.getDaftar();

        // Lebar kolom dihitung dari isi terpanjang, sehingga kolom selalu sejajar rapi.
        int[] lebar = new int[HEADER.length];
        for (int i = 0; i < HEADER.length; i++) {
            lebar[i] = HEADER[i].length();
        }
        for (Koleksi k : daftar) {
            String[] baris = barisData(k);
            for (int i = 0; i < baris.length; i++) {
                lebar[i] = Math.max(lebar[i], baris[i].length());
            }
        }
        String format = "%-" + lebar[0] + "s  %-" + lebar[1] + "s  %-" + lebar[2] + "s  %-"
                + lebar[3] + "s  %-" + lebar[4] + "s  %-" + lebar[5] + "s%n";

        // try-with-resources: aliran otomatis ditutup.
        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(namaBerkas), StandardCharsets.UTF_8);
             PrintWriter out = new PrintWriter(bw)) {
            out.printf(format, (Object[]) HEADER);
            int total = lebar[0] + lebar[1] + lebar[2] + lebar[3] + lebar[4] + lebar[5] + 10;
            out.println("-".repeat(total));
            for (Koleksi k : daftar) {
                out.printf(format, (Object[]) barisData(k));
            }
        }
    }

    private String[] barisData(Koleksi k) {
        return new String[]{
                k.jenis(),
                k.getKode(),
                k.getJudul(),
                String.valueOf(k.getTahunTerbit()),
                k.layakDipinjam() ? "Ya" : "Tidak",
                k.isSedangDipinjam() ? "Dipinjam" : "Tersedia"
        };
    }
}
