package eksepsi;

/** Induk seluruh eksepsi pada sistem SIPUSTA. */
public class PustakaException extends Exception {

    public PustakaException(String pesan) {
        super(pesan);
    }
}
