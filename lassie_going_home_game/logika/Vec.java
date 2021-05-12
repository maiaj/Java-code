package logika;

public class Vec {
    private String nazev;
    private boolean jePocuratelna; // TODO: zrobic ohen jako samostatnom tride albo go dac do prostoru
    private int stav;

    public Vec(String nazev,  boolean jePocuratelna) {
        this.nazev = nazev;
        this.jePocuratelna = jePocuratelna;
        this.stav = stav;
    }

    public String getNazev() {
        return nazev;
    }

    public boolean isJePocuratelna() {
        return jePocuratelna;
    }

    public int getStav() {
        return stav;
    }

    public void setStav(int stav) {
        this.stav = stav;
    }
}
