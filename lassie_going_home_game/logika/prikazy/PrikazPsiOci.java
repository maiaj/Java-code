package logika.prikazy;

import logika.HerniPlan;
import logika.Postava;
import logika.Pruchod;
import logika.SchopnostPostavy;

public class PrikazPsiOci implements IPrikaz {
  private static final String NAZEV = "oci";
  private final HerniPlan plan;

  public PrikazPsiOci(HerniPlan plan) {
    this.plan = plan;
  }

  @Override
  public String provedPrikaz(String... parametry) {
    Postava postava = this.plan.getAktualniProstor().getPostava();
    if (postava == null || !postava.getFungujiPsiOci()) {
      return "Tady ti psí oči nepomůžou.";
    }
    if (postava.getSchopnost().equals(SchopnostPostavy.ODTAJNUJE_VYCHOD)) {
      for (Pruchod pruchod : this.plan.getAktualniProstor().getTajnePruchody()) {
        pruchod.setJeViditelny(true);
        return "Tvoje psí oči zabraly, "
            + postava.getPopis()
            + " tě podrbe za uchem a můžeš jít ven! "
            + this.plan.getAktualniProstor().dlouhyPopis();
      }
      return "Žádný tajný průchod už tady není.";
    } else if (postava.getSchopnost().equals(SchopnostPostavy.ZAVEZE_DO_CILE)) {
      if (this.plan.getPes().maObojek()) {
        this.plan.setAktualniProstor(this.plan.getKonecnyProstor());
        return "Výborně, řidič se podívá na tvůj obojek, na kterém máš svou starou adresu a zaveze tě domů.\n"
            + this.plan.getKonecnyProstor().getPopis();
      } else {
        this.plan.getAktualniProstor().setMaJidlo(true);
        return "Bohužel nemáš obojek s adresou. "
            + postava.getPopis()
            + " neví, co s tebou, dá ti svou svačinu, kterou můžeš sníst a nechá tě být.";
      }
    } else if (postava.getSchopnost().equals(SchopnostPostavy.DAVA_JIDLO_A_VODU)) {
      this.plan.getAktualniProstor().setMaJidlo(true);
      this.plan.getAktualniProstor().setMaVodu(true);
      return "Máš štěstí, " + postava.getPopis() + " tí dá něco k snědku a vodu.";
    }
    throw new RuntimeException("Neznámá schopnost.");
  }

  @Override
  public String getNazev() {
    return NAZEV;
  }
}
