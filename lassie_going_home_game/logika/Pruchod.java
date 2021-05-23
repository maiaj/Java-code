package logika;

public class Pruchod {
  private boolean jeHrabatelny;
  private final Prostor cilovyProstor;
  private boolean jeViditelny;

  public Pruchod(boolean jeViditelny, boolean jeHrabatelny, Prostor cilovyProstor) {
    this.jeViditelny = jeViditelny;
    this.jeHrabatelny = jeHrabatelny;
    this.cilovyProstor = cilovyProstor;
  }

  public boolean jeViditelny() {
    return this.jeViditelny;
  }

  public void setJeViditelny(boolean jeViditelny) {
    this.jeViditelny = jeViditelny;
  }

  public boolean prohrabat() {
    if (!this.jeHrabatelny()) {
      return false;
    }
    this.jeViditelny = true;
    this.jeHrabatelny = false;
    return true;
  }

  public boolean jeHrabatelny() {
    return this.jeHrabatelny;
  }

  public Prostor getCilovyProstor() {
    return this.cilovyProstor;
  }
}
