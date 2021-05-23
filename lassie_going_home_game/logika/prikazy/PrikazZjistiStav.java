package logika.prikazy;

import logika.HerniPlan;

public class PrikazZjistiStav implements IPrikaz {
  private static final String NAZEV = "stav";
  private final HerniPlan plan;

  public PrikazZjistiStav(HerniPlan plan) {
    this.plan = plan;
  }

  @Override
  public String provedPrikaz(String... parametry) {
    String oznaceni;
    if (this.plan.getAktualniProstor().jeOznaceny()) {
      oznaceni = " Tady uz jis byl.";
    } else {
      oznaceni = " Tady jsi ještě nebyl.";
    }

    return "Jsi v prostoru "
        + this.plan.getAktualniProstor().getNazev()
        + "."
        + oznaceni
        + " Máš "
        + this.plan.getPes().getJidlo()
        + " jednotek jídla a "
        + this.plan.getPes().getVoda()
        + " jednotek vody.\n"
        + this.plan.getAktualniProstor().popisVychodu();
  }

  @Override
  public String getNazev() {
    return NAZEV;
  }
}
