package logika.prikazy;

import logika.HerniPlan;
import logika.Prostor;
import logika.Pruchod;

/*
 * Prikaz jdi umoznuje psovi vejít do zadaného prostoru. Pokud prostor
 * existuje, vstoupí se do nového prostoru. Pokud zadaný sousední prostor
 * (východ) není, vypíše se chybové hlášení.
 */

public class PrikazJdi implements IPrikaz {
  private static final String NAZEV = "jdi";
  private final HerniPlan plan;

  public PrikazJdi(HerniPlan plan) {
    this.plan = plan;
  }

  @Override
  public String provedPrikaz(String... parametry) {
    if (plan.getPes().getJidlo() <= 0) {
      return "Nemáš dost jídla. Najez se nebo zaštěkej a vrátíš se do kotce.";
    } else if (plan.getAktualniProstor().getViditelnePruchody().isEmpty()) {
      return "Tady není žádný viditelný východ.";
    } else {
      if (parametry.length == 0) {
        // pokud chybí druhé slovo (sousední prostor), tak ....
        return "Kam mám jít? Musíš zadat jméno východu";
      } else {
        String nazevCilovehoProstoru = parametry[0];
        Pruchod moznyPruchod = plan.getAktualniProstor().vratMoznyPruchod(nazevCilovehoProstoru);
        if (moznyPruchod == null) {
          return "Tam se odsud jít nedá!";
        }
        Prostor cilovyProstor = moznyPruchod.getCilovyProstor();
        plan.setAktualniProstor(cilovyProstor);
        plan.getPes().uberJidlo();
        if (cilovyProstor.equals(plan.getKonecnyProstor())) {
          return plan.getKonecnyProstor().getPopis();
        } else {
          return cilovyProstor.dlouhyPopis();
        }
      }
    }
  }

  @Override
  public String getNazev() {
    return NAZEV;
  }
}
