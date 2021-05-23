package logika.prikazy;

import logika.HerniPlan;

public class PrikazSeber implements IPrikaz {
  private static final String NAZEV = "seber";
  private final HerniPlan plan;

  public PrikazSeber(HerniPlan plan) {
    this.plan = plan;
  }

  @Override
  public String provedPrikaz(String... parametry) {
    if (parametry.length != 1) {
      return "Co mám sebrat? Zadej název věci, která je v prostoru.";
    }
    String nazevVeci = parametry[0];
    if (!this.plan.getAktualniProstor().obsahujeSebratelouVec(nazevVeci)) {
      return "Tento předmět neznám.";
    }
    if (this.plan.getPes().seberVec(nazevVeci)) {
      this.plan.getAktualniProstor().odeberVec(nazevVeci);
      return "Sebral jsi " + nazevVeci + ".";
    }
    return nazevVeci + " už máš.";
  }

  @Override
  public String getNazev() {
    return NAZEV;
  }
}
