package logika;

public class Pes {
    private int jidlo;
    private int voda;
    private int maxJidlo = 10;
    private int maxVoda = 10;
    private boolean maKlacek = false;
    private boolean maObojek = false;

    public Pes(int jidlo, int voda) {
        this.jidlo = jidlo;
        this.voda = voda;
    }

    public int getMaxJidlo() {
        return maxJidlo;
    }

    public int getMaxVoda() {
        return maxVoda;
    }

    public boolean isMaKlacek() {
        return maKlacek;
    }

    public boolean isMaObojek() {
        return maObojek;
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
        if (this.voda > this.maxVoda) {
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
        uberVodu(!isMaKlacek() ? 10 : 5);
    }


    public void setMaKlacek(boolean maKlacek) {
        this.maKlacek = maKlacek;
    }

    public void setMaObojek(boolean maObojek) {
        this.maObojek = maObojek;
    }

    public void setJidlo(int jidlo) {
        this.jidlo = jidlo;
    }

    public void setVoda(int voda) {
        this.voda = voda;
    }
}


