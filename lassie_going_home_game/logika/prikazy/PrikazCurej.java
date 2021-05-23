package logika.prikazy;

import logika.HerniPlan;

/* Tento prikaz umoznuje psovi curat.
Curani slouzi k uhaseni ohne (pokud je v prostoru)
nebo k oznaceni prostoru za ucelem udrzovani prehledu o tom, kde uz pes byl.
*/

public class PrikazCurej implements IPrikaz {
  private static final String NAZEV = "curej";
  private final HerniPlan plan;

  public PrikazCurej(HerniPlan plan) {
    this.plan = plan;
  }

  @Override
  public String provedPrikaz(String... parametry) {
    if (plan.getPes().getVoda() <= 0) {
      return "Nemáš dost vody. Napij se.";
    }

    if (plan.getAktualniProstor().obsahujeVec("ohen")) {
      if (!plan.getPes().muzeHasit()) {
        return "Nemáš dost vody na to, abys oheň uhasil.";
      }
      plan.getAktualniProstor().odeberVec("ohen");
      plan.getPes().hasit();
      plan.getAktualniProstor().getTajnePruchody().forEach(pruchod -> pruchod.setJeViditelny(true));
      return "Hurá! Uhasil si oheň! Konečně vidíš co je na druhé straně staveniště. "
          + plan.getAktualniProstor().popisVychodu();
    } else {
      if (plan.getAktualniProstor().isJeOznaceny()) {
        return "Tady už jsi byl.";
      }
      plan.getAktualniProstor().setJeOznaceny(true);
      plan.getPes().uberVodu(1);
      return "Označkoval sis tento prostor. Příště tak poznáš, že už jsi tady byl.";
    }
  }

  @Override
  public String getNazev() {
    return NAZEV;
  }
}
