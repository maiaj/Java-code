package logika;

public class Pes {
    private int jidlo;
    private int voda;
    private int maxJidlo = 10;
    private int maxVoda = 10;
    private boolean maKlacek;
    private boolean maObojek;

    public Pes(int jidlo, int voda, boolean maKlacek, boolean maObojek) {
        this.jidlo = jidlo;
        this.voda = voda;
        this.maKlacek = maKlacek;
        this.maObojek = maObojek;
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

    public int zjistiStavJidla() {
        return this.jidlo;
    }

    public int zjistiStavVody() {
        return this.voda;
    }

    public void pridejJidlo(int jednotka) {
        if (this.jidlo <= this.maxJidlo) {
            this.jidlo = jidlo + jednotka;
        }
    }

    public void uberJidlo() {
        if (this.jidlo >= 0) {
            this.jidlo--;
        }
    }

    public void pridejVodu(int jednotka) {
        if (this.voda <= this.maxVoda) {
            this.voda = voda + jednotka;
        }
    }

    public void uberVodu(int jednotka) {
        if (this.voda >= 0) {
            this.voda = voda - jednotka;
        }
    }

    public void setMaKlacek(boolean maKlacek) {
        this.maKlacek = maKlacek;
    }

    public void setMaObojek(boolean maObojek) {
        this.maObojek = maObojek;
    }
}


