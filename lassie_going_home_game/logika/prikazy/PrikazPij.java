package logika.prikazy;

import logika.HerniPlan;

public class PrikazPij implements IPrikaz {
  private static final String NAZEV = "pij";
  private final HerniPlan plan;

  public PrikazPij(HerniPlan plan) {
    this.plan = plan;
  }

  @Override
  public String provedPrikaz(String... parametry) {
    if (plan.getPes().getVoda() < plan.getPes().getMaxVoda()) {
      if (plan.getAktualniProstor().getJeTamVoda()) {
        plan.getPes().pridejVodu(1);
        plan.getAktualniProstor().setJeTamVoda(false);
        return "Máš " + plan.getPes().getVoda() + " jednotek vody.";
      } else {
        return "Tady se bohužel ničeho nenapiješ.";
      }
    } else {
      return "Vody už máš dost.";
    }
  }

  @Override
  public String getNazev() {
    return NAZEV;
  }
}
