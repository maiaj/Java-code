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
        int stavJidla = plan.getPes().zjistiStav("jidlo");
        int stavVody = plan.getPes().zjistiStav("voda");
        String novyText = "Máš " + stavJidla + " jednotek jídla a " + stavVody + " jednotek vody."; // TODO: staw wiecy a aktualny prostor
        return novyText;
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}
