package logika.prikazy;

import logika.HerniPlan;
import logika.Pruchod;

public class PrikazHrabej implements IPrikaz {
    private static final String NAZEV = "hrabej";
    private HerniPlan plan;

    public PrikazHrabej(HerniPlan plan) {
        this.plan = plan;
    }

    @Override
    public String provedPrikaz(String... parametry) {
        if (plan.getAktualniProstor().getJeHrabatelny() == true) {
            plan.getAktualniProstor().setJeTamJidlo(true);
            plan.getAktualniProstor().setJeHrabatelny(false);
            return "Vyhrabal jsi mrtvou veverku. Pochutnej si. " + plan.getAktualniProstor().dlouhyPopis();
        } else {
            for (Pruchod pruchod : plan.getAktualniProstor().getTajnePruchody()) {
                if (pruchod.prohrabat()) {
                    plan.getAktualniProstor().setPruchod(pruchod);
                    return "Podařilo se ti vyhrabat dost velkou díru. Dobrá práce! " + "\n" + plan.getAktualniProstor().popisVychodu();
                }
            }
        }
        return "Tady nic nevyhrabeš.";
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}
