package logika.prikazy;

import logika.HerniPlan;

public class PrikazZjistiStav implements IPrikaz {
    private static final String NAZEV = "stav";
    private final HerniPlan plan;

    public PrikazZjistiStav(HerniPlan plan) {
        this.plan = plan;
    }

    @Override
    public String provedPrikaz(String... parametry) {
        return "Jsi v prostoru " + plan.getAktualniProstor().getNazev() + ". Máš "
                + plan.getPes().getJidlo() + " jednotek jídla a "
                + plan.getPes().getVoda() + " jednotek vody.";
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}
