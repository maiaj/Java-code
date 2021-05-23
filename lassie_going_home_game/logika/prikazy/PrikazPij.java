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
    if (!this.plan.getPes().muzeJestePrijmoutVodu()) {
      return "Vody už máš dost.";
    }
    if (!this.plan.getAktualniProstor().getMaVodu()) {
      return "Tady nic k pití není.";
    }

    this.plan.getPes().pridejVodu(1);
    this.plan.getAktualniProstor().setMaVodu(false);
    return "Máš " + this.plan.getPes().getVoda() + " jednotek vody.";
  }

  @Override
  public String getNazev() {
    return NAZEV;
  }
}
