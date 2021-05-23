package logika.prikazy;

import logika.HerniPlan;

/* Tento prikaz umoznuje psovi jist jidlo, ktere je v prostoru.
Jidlo je potreba k tomu, aby pes mohl chodit. Kazdy prikaz jez pridava 1 jednotku jidla.
*/

public class PrikazJez implements IPrikaz {
  private static final String NAZEV = "jez";
  private final HerniPlan plan;

  public PrikazJez(HerniPlan plan) {
    this.plan = plan;
  }

  @Override
  public String provedPrikaz(String... parametry) {
    if (!this.plan.getPes().muzeJestePrijmoutJidlo()) {
      return "Jídla už máš dost.";
    }
    if (!this.plan.getAktualniProstor().getMaJidlo()) {
      return "Tady nic k snědku není.";
    }

    this.plan.getPes().pridejJidlo(1);
    this.plan.getAktualniProstor().setMaJidlo(false);
    return "Máš " + this.plan.getPes().getJidlo() + " jednotek jídla.";
  }

  @Override
  public String getNazev() {
    return NAZEV;
  }
}
