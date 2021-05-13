package logika;

public class Vec {
    private String nazev;
    private boolean jdeSebrat;


    public Vec(String nazev, boolean jdeSebrat) {
        this.nazev = nazev;
        this.jdeSebrat = jdeSebrat;
    }

    public String getNazev() {
        return nazev;
    }

    public boolean isJdeSebrat() {
        return jdeSebrat;
    }
}
