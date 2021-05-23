package logika.prikazy;

import logika.HerniPlan;
import logika.Pruchod;
import logika.Schopnosti;

public class PrikazPsiOci implements IPrikaz {
  private static final String NAZEV = "oci";
  private final HerniPlan plan;

  public PrikazPsiOci(HerniPlan plan) {
    this.plan = plan;
  }

  @Override
  public String provedPrikaz(String... parametry) {
    if (plan.getAktualniProstor().getPostava() == null
        || !plan.getAktualniProstor().getPostava().getFungujiPsiOci()) {
      return "Tady ti psí oči nepomůžou.";
    }
    if (plan.getAktualniProstor()
        .getPostava()
        .getSchopnosti()
        .equals(Schopnosti.ODTAJNUJE_VYCHOD)) {
      for (Pruchod pruchod : plan.getAktualniProstor().getTajnePruchody()) {
        pruchod.setJeViditelny(true);
        plan.getAktualniProstor().setPruchod(pruchod);
        return "Tvoje psí oči zabraly, "
            + plan.getAktualniProstor().getPostava().getPopis()
            + " tě podrbe za uchem a pustí tě ven! "
            + plan.getAktualniProstor().dlouhyPopis();
      }
    } else if (plan.getAktualniProstor()
        .getPostava()
        .getSchopnosti()
        .equals(Schopnosti.ZAVEZE_DO_CILE)) {
      if (plan.getPes().isMaObojek()) {
        plan.setAktualniProstor(plan.getKonecnyProstor());
        return "Výborně, řidič se podívá na tvůj obojek, na kterém máš svou starou adresu a zaveze tě domů.\n "
            + plan.getKonecnyProstor().getPopis();
      }
      plan.getAktualniProstor().setJeTamJidlo(true);
      return "Bohužel nemáš obojek s adresou. "
          + plan.getAktualniProstor().getPostava().getPopis()
          + " neví, co s tebou, dá ti svou svačinu a nechá tě být.";
    }
    plan.getAktualniProstor().setJeTamJidlo(true);
    plan.getAktualniProstor().setJeTamVoda(true);
    return "Máš štěstí, "
        + plan.getAktualniProstor().getPostava().getPopis()
        + " tě nakrmí a dá ti vodu.";
  }

  @Override
  public String getNazev() {
    return NAZEV;
  }
}
