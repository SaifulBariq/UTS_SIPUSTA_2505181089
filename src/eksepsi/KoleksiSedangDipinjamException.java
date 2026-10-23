package eksepsi;

public class KoleksiSedangDipinjamException extends PustakaException {

    public KoleksiSedangDipinjamException(String judul) {
        super("Maaf, \"" + judul + "\" sedang dipinjam oleh pengguna lain. "
                + "Silakan coba lagi setelah koleksi ini dikembalikan.");
    }
}
