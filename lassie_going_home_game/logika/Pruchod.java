package logika;

public class Pruchod {
    private boolean jeViditelny;
    private final boolean jeHrabatelny;
    private final Prostor cilovyProstor;

    public Pruchod(boolean jeViditelny, boolean jeHrabatelny, Prostor cilovyProstor) {
        this.jeViditelny = jeViditelny;
        this.jeHrabatelny = jeHrabatelny;
        this.cilovyProstor = cilovyProstor;
    }

    public boolean isJeViditelny() {
        return jeViditelny;
    }

    public boolean prohrabat() {
        if (!isJeHrabatelny()) {
            return false;
        }
        jeViditelny = true;
        return true;
    }

    public boolean isJeHrabatelny() {
        return jeHrabatelny;
    }

    public Prostor getCilovyProstor() {
        return cilovyProstor;
    }

    public void setJeViditelny(boolean jeViditelny) {
        this.jeViditelny = jeViditelny;
    }

}
