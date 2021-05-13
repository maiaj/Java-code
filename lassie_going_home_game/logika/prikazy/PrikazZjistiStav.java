package logika.prikazy;

import logika.HerniPlan;

public class PrikazZjistiStav implements IPrikaz {
    private static final String NAZEV = "stav";
    private HerniPlan plan;

    public PrikazZjistiStav(HerniPlan plan) {
        this.plan = plan;
    }


    @Override
    public String provedPrikaz(String... parametry) {
        return "Jsi v prostoru " + plan.getAktualniProstor().getNazev() + ". Máš " + plan.getPes().zjistiStavJidla() + " jednotek jídla a " + plan.getPes().zjistiStavVody() + " jednotek vody."; // TODO: staw wiecy a aktualny prostor
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}
