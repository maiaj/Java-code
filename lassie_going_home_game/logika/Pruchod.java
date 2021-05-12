package logika;

public class Pruchod {
    private boolean jeViditelny;
    private boolean jeHrabatelny;
    private Prostor cilovyProstor;

    public Pruchod(boolean jeViditelny, boolean jeHrabatelny, Prostor cilovyProstor) {
        this.jeViditelny = jeViditelny;
        this.jeHrabatelny = jeHrabatelny;
        this.cilovyProstor = cilovyProstor;
    }

    public boolean isJeViditelny() {
        return jeViditelny;
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
