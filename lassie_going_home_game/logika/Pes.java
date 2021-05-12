package logika;

public class Pes {
    private int jidlo;
    private int voda;
    private boolean maKlacek;
    private boolean maObojek;

    public Pes(int jidlo, int voda, boolean maKlacek, boolean maObojek) {
        this.jidlo = jidlo;
        this.voda = voda;
        this.maKlacek = maKlacek;
        this.maObojek = maObojek;
    }

    public boolean isMaKlacek() {
        return maKlacek;
    }

    public boolean isMaObojek() {
        return maObojek;
    }

    public int zjistiStav(String string) { // TODO: 2 metody na jedzyni a wode osobno
        int aktualniStav = 0;

        if (string == "jidlo") {
            aktualniStav = this.jidlo;
        }
        if (string == "voda") {
            aktualniStav = this.voda;
        }
        return aktualniStav;
    }

    public void pridejJidlo(int jednotka) {
        this.jidlo = jidlo + jednotka;
    }

    public void uberJidlo() {
        this.jidlo--;
    }

    public void pridejVodu(int jednotka) {
        this.voda = voda + jednotka;
    }

    public void uberVodu() {
        this.voda--;
    }

    public String pridejKlacek() {
        if (this.maKlacek == true) {
            return "Už jeden klacek máš.";
        } else {
            this.maKlacek = true;
            return "Sebral jsi klacek.";
        }
    }

    public String pridejObojek() {
        this.maObojek = true;
        return "Sebral jsi obojek.";
    }
}


