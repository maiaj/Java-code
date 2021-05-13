package logika.prikazy;

import logika.HerniPlan;

public class PrikazPij implements IPrikaz {
    private static final String NAZEV = "pij";
    private HerniPlan plan;

    public PrikazPij(HerniPlan plan) {
        this.plan = plan;
    }

    @Override
    public String provedPrikaz(String... parametry) {
        if (plan.getPes().zjistiStavVody() < plan.getPes().getMaxVoda()) {
            if (plan.getAktualniProstor().getJeTamVoda() == true) {
                plan.getPes().pridejVodu(1);
                plan.getAktualniProstor().setJeTamVoda(false);
                return "Máš " + plan.getPes().zjistiStavVody() + " jednotek vody.";
            } else {
                return "Tady se bohužel ničeho nenapiješ.";
            }
        } else {
            return "Vody už máš dost.";
        }
    }


    @Override
    public String getNazev() {
        return NAZEV;
    }
}
