package eksepsi;

public class KoleksiTidakLayakException extends PustakaException {

    public KoleksiTidakLayakException(String judul, String alasan) {
        super("Maaf, \"" + judul + "\" belum dapat dipinjam karena " + alasan + ". "
                + "Silakan pilih koleksi lain.");
    }
}
