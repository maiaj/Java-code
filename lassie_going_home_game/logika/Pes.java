package logika;

import java.util.HashSet;
import java.util.Set;

public class Pes {
    private int jidlo;
    private int voda;
    private final int maxJidlo = 10;
    private final int maxVoda = 10;
    private final Set<String> sebraneVeci = new HashSet<>();

    public Pes(int jidlo, int voda) {
        this.jidlo = jidlo;
        this.voda = voda;
    }

    public int getMaxVoda() {
        return maxVoda;
    }

    public boolean isMaKlacek() {
        return sebraneVeci.contains("klacek");
    }

    public boolean isMaObojek() {
        return sebraneVeci.contains("obojek");
    }

    public int getJidlo() {
        return this.jidlo;
    }

    public int getVoda() {
        return this.voda;
    }

    public void pridejJidlo(int jednotka) {
        if (this.maxJidlo >= this.jidlo) {
            this.jidlo = this.jidlo + jednotka;
        }
    }

    public void uberJidlo() {
        if (this.jidlo <= 0) {
            return;
        }
        this.jidlo--;
    }

    public void pridejVodu(int jednotka) {
        if (this.voda > this.maxVoda) { // TODO je mozne pridat nad max
            return;
        }
        this.voda = this.voda + jednotka;
    }

    public void uberVodu(int jednotka) {
        if (this.voda >= jednotka) {
            this.voda = this.voda - jednotka;
        }
    }

    public boolean muzeJestePrijmoutJidlo() {
        return this.jidlo < this.maxJidlo;
    }

    public boolean muzeHasit() {
        return !isMaKlacek() && this.voda >= 10 || isMaKlacek() && this.voda >= 5;
    }

    public void hasit() {
        uberVodu(isMaKlacek() ? 5 : 10);
    }

    public boolean seberVec(String nazevVeci) {
        return sebraneVeci.add(nazevVeci);
    }

    public void setJidlo(int jidlo) {
        this.jidlo = jidlo;
    }

    public void setVoda(int voda) {
        this.voda = voda;
    }
}


