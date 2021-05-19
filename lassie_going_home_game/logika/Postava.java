package logika;

public class Postava {
    private String jmeno;
    private String popis;
    private boolean fungujiPsiOci;
    private Schopnosti schopnosti;

    public Postava(String jmeno, String popis, Boolean fungujiPsiOci, Schopnosti schopnosti) {
        this.jmeno = jmeno;
        this.popis = popis;
        this.fungujiPsiOci = fungujiPsiOci;
        this.schopnosti = schopnosti;
    }

    public String getJmeno() {
        return jmeno;
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
