package logika.prikazy;

import java.util.Optional;
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
    if (parametry.length == 0) {
      // pokud chybí druhé slovo (sousední prostor), tak ....
      return "Kam mám jít? Musíš zadat jméno východu";
    }
    if (this.plan.getPes().getJidlo() <= 0) {
      return "Nemáš dost jídla. Najez se nebo zaštěkej a vrátíš se do kotce.";
    } else if (this.plan.getAktualniProstor().getViditelnePruchody().isEmpty()) {
      return "Tady není žádný viditelný východ.";
    }
    String nazevCilovehoProstoru = parametry[0];
    Optional<Pruchod> moznyPruchod = this.plan.getAktualniProstor().vratMoznyPruchod(nazevCilovehoProstoru);
    if (moznyPruchod.isEmpty()) {
      return "Tam se odsud jít nedá!";
    }
    Prostor cilovyProstor = moznyPruchod.get().getCilovyProstor();
    this.plan.setAktualniProstor(cilovyProstor);
    this.plan.getPes().uberJidlo();
    if (cilovyProstor.equals(this.plan.getKonecnyProstor())) {
      return this.plan.getKonecnyProstor().getPopis();
    } else {
      return cilovyProstor.dlouhyPopis()
          + ". Máš "
          + this.plan.getPes().getJidlo()
          + " jednotek jídla a "
          + this.plan.getPes().getVoda()
          + " jednotek vody.";
    }
  }

  @Override
  public String getNazev() {
    return NAZEV;
  }
}
