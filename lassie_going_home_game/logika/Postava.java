package logika;

public class Postava {
    private String jmeno;
    private String popis;
    private boolean fungujiPsiOci;
    private boolean odtajnujeVychod;
    private boolean davaJidloAVodu;
    private boolean zavezeDoCile;

    public Postava(String jmeno, String popis, Boolean fungujiPsiOci, boolean odtajnujeVychod, boolean davaJidloAVodu, boolean zavezeDoCile) {
        this.jmeno = jmeno;
        this.popis = popis;
        this.fungujiPsiOci = fungujiPsiOci;
        this.odtajnujeVychod = odtajnujeVychod;
        this.davaJidloAVodu = davaJidloAVodu;
        this.zavezeDoCile = zavezeDoCile;
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

    public boolean isOdtajnujeVychod() {
        return odtajnujeVychod;
    }

    public boolean isDavaJidloAVodu() {
        return davaJidloAVodu;
    }

    public boolean isZavezeDoCile() {
        return zavezeDoCile;
    }
}
