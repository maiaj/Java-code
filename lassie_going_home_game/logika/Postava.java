package logika;

public class Postava {
    private final String popis;
    private final boolean fungujiPsiOci;
    private final Schopnosti schopnosti;

    public Postava(String popis, Boolean fungujiPsiOci, Schopnosti schopnosti) {
        this.popis = popis;
        this.fungujiPsiOci = fungujiPsiOci;
        this.schopnosti = schopnosti;
    }

    public String getPopis() {
        return popis;
    }

    public Boolean getFungujiPsiOci() {
        return fungujiPsiOci;
    }

    public Schopnosti getSchopnosti() {
        return schopnosti;
    }
}
