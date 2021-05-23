package logika.prikazy;

import logika.HerniPlan;

/*
Prikaz stekej umoznuje psovi vratit se v kterekoli fazi hry zpatky do kotce.
Zaroven se mu navysi stav jidla a vody na pocatecni hodnotu.
 */

public class PrikazStekej implements IPrikaz {
  private static final String NAZEV = "stekej";
  private final HerniPlan plan;

  public PrikazStekej(HerniPlan plan) {
    this.plan = plan;
  }

  @Override
  public String provedPrikaz(String... parametry) {
    if (this.plan.getAktualniProstor().equals(this.plan.getPocatecniProstor())) {
      return "Jsi v kotci. Tady můžeš štěkat kolik chcseš a nic to neudělá.";
    } else {
      this.plan.resetujHerniPlan();
      this.plan.getPes().resetujJidloAVodu();
      return "Tvoje štěkání přivolalo farmáře, který tě zavezl zpátky na farmu a zavřel tě do kotce. Jsi zase na začátku.\n"
          + this.plan.getAktualniProstor().dlouhyPopis();
    }
  }

  @Override
  public String getNazev() {
    return NAZEV;
  }
}
